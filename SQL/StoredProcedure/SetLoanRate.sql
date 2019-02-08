CREATE DEFINER=`root`@`localhost` PROCEDURE `SetLoanRate`(in employeeID int, in clientID int, in loanID int, in rate decimal(3,1))
BEGIN
declare clientExist int;
declare loanExist int;
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
  
    select count(*) into clientExist from Kund
    where idKund=clientID;
    
    select count(*) into loanExist from Lan
    where kundId=clientId and idLan=loanID;
    
    select bevilja into loanStatus from Lan
	where kundId=clientID and idLan=loanID;
    
    if(clientExist >0) then
      if(loanExist>0) then
		if(loanStatus=1) then
            insert into hanteraLan(lanId, lanrantesats, date,anstalldId) values
            (loanID, rate, current_timestamp(), employeeID);
            
	        update Lan 
            set lanRantesats=rate
            where idLan=loanID;
          end if;
		end if;
	end if;
      
    select ('') as error;
	commit;   
END