CREATE DEFINER=`root`@`localhost` PROCEDURE `Withdraw`(in employeeID int, in clientID int, in accountID int, in amount int)
BEGIN
declare clientExist int;
declare accountExist int;
declare enoughAmount int;
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
      
    select saldo into @s from Konto
    where kundId=clientId and idKonto=accountID;
    
    set enoughAmount=@s-amount;
    
    if(clientExist >0) then
      if(accountExist>0) then
        if(accountStatus=0) then
          if(enoughAmount>=0) then
            insert into hanteraKonto(kontoId, tautsaldo, date,anstalldId) values
            (accountID, amount, current_timestamp(), employeeID);
    
	        update Konto 
            set saldo=@s-amount
            where idKonto=accountID;
            elseif(enoughAmount<0) then
            select ('Insufficient Balance') as error;
            end if;
          end if;
		end if;
	end if;
      
    select ('') as error;
	commit;   
END