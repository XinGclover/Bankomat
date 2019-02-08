CREATE DEFINER=`root`@`localhost` PROCEDURE `GrantLoan`(in employeeID int, in clientID int, in loanID int)
BEGIN
declare loanExist int;
declare clientExist int;
declare loanStatus boolean;
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
     select count(*) into clientExist from Lan
     where kundId=clientID; 
     
     select count(*) into loanExist from Lan
     where kundId=clientID;
     
     select bevilja into loanStatus from Lan
	where kundId=clientID and idLan=loanID;
     
	 if(clientExist >0) then
	   if(loanExist>0) then
         if(loanStatus=0) then
           insert into hanteraLan(lanId,bevilja,anstalldId,date) values
           (loanID,1,employeeID,current_timestamp());
           
           update Lan
           set bevilja=1
		   where kundId=clientID and idLan=loanID;
		  end if;
		end if;
      end if;      
      
    select ('') as error;
	commit;   
END