CREATE DEFINER=`root`@`localhost` PROCEDURE `ClientWithdrawCash`(in clientID int, in accountID int, in cash int)
BEGIN
declare accountExist int;
declare enoughMoney int;
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
	select count(*) into accountExist from Konto
    where kundId=clientId and idKonto=accountID;
    
    select avsluta into accountStatus from Konto
	where kundId=clientID and idKonto=accountID;
    
    select saldo into @balance from Konto
    where idKonto=accountID and kundId=clientID;
    
    set enoughMoney=@balance-cash;
   
   if(accountExist>0) then
	if(accountStatus=0) then    
      if(enoughMoney>=0) then 
        insert into hanteraKonto (kontoId,tautsaldo,kundId,date) values
        (accountID,cash,clientID,current_timestamp());
           
	    update Konto
	    set saldo=enoughMoney
        where idKonto=accountID;
      
       else
		select ('No enough Money') as error;
        end if;
	  end if;
	end if;
    
    
    select ('') as error;
	commit;
		
   
END