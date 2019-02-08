CREATE DEFINER=`root`@`localhost` PROCEDURE `AssignAccount`(in employeeID int, in clientID int, in AccountNumber int)
BEGIN
declare clientExist int;
declare accountExist int;

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
     where kundId=clientID and number=AccountNumber;
     
     if(clientExist >0) then
      if(accountExist<1) then
       insert into Konto(number,kundId,avsluta) values
       (AccountNumber, clientID, 0);
       
       insert into hanteraKonto(kontoId,skapa,anstalldId,date) values
       (last_insert_id(),1,employeeID,current_timestamp());
      end if; 
	 end if;
      
    select ('') as error;
	commit;   
END