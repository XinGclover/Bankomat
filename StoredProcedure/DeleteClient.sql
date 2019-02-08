CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteClient`(in employeeID int, in clientID int)
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
     where idKund=clientID;
     
     if(clientExist>0) then
       delete from Kund
       where idKund=clientID;
      end if;      
      
    select ('') as error;
	commit;   
END