CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateInfo`(in clientID int, in oPIN int, in clientName varchar(45), in clientAddress varchar(45), in clientTelephone varchar(45))
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
         update Kund 
         set PIN=oPIN,
              namn=clientName,
              address=clientAddress,
              telefon=clientTelephone
		 where idKund=clientID;
	
       end if;
	
    -- select ('') as error;
	commit;
    
END