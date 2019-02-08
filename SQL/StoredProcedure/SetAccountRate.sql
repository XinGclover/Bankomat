CREATE DEFINER=`root`@`localhost` PROCEDURE `SetAccountRate`(in employeeID int, in clientID int, in accountID int, in rate decimal(3,1))
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
            insert into hanteraKonto(kontoId,rantesats, date,anstalldId) values
            (accountID,rate, current_timestamp(), employeeID);
            
	        update Konto 
            set sparaRantesats=rate
            where idKonto=accountID;
          end if;
		end if;
	end if;
      
    select ('') as error;
	commit;   
END