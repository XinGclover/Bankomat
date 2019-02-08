CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateNewClient`(in employeeID int,  in clientNumber int)
BEGIN
declare clientExist int;

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
     where personnummer=clientNumber;
     
     if(clientExist<1) then
       insert into Kund(personnummer,skapaAnstalldId,skapaDate) values
       (clientNumber,employeeID,current_timestamp());
      end if;      
      
    select ('') as error;
	commit;   
    
END