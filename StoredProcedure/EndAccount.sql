CREATE DEFINER=`root`@`localhost` PROCEDURE `EndAccount`(in employeeID int, in clientID int, in AccountID int)
BEGIN
declare clientExist int;
declare accountExist int;
declare accountStatus boolean;
DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          ROLLBACK;
          select ('SQLEXCEPTION occurred, rollback done') as error;
    END;
    
 	DECLARE EXIT HANDLER FOR 1062
 	begin
 		ROLLBACK;
 	 	select ('unique constraint broken, rollback done') as error;
 	END;
	
  start transaction;
      select count(*) into clientExist from Kund
      where idKund=clientID;
    
      select count(*) into accountExist from Konto
      where kundId=clientId and idKonto=accountID;
  
      select avsluta into accountStatus from Konto
      where kundId=clientID and idKonto=accountID;

      if(clientExist >0) then
	   if(accountExist>0) then
        if(accountStatus=0) then		  
           insert into hanteraKonto(kontoId,avsluta,anstalldId,date) values
           (accountID,1,employeeID,current_timestamp());
           
           update Konto
           set avsluta=1
		   where kundId=clientID and idKonto=accountID;
          
         end if;
		end if;
	   end if;
      
    select ('') as error;
	commit;   
END