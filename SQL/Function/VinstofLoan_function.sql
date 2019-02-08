CREATE DEFINER=`root`@`localhost` FUNCTION `VinstofLoan`(loanID int) RETURNS decimal(20,1)
    READS SQL DATA
    DETERMINISTIC
BEGIN
declare vinst decimal(20,1);

select date(date) into @begin from hanteraLan
where lanId=loanID and bevilja=1;

select betalplan into @end from Lan
where idLan=loanID;

select datediff(@end, @begin) into @period;

select lanAntal into @amount from Lan
where idLan=loanID;

select lanRantesats into @rate from Lan
where idLan=loanID;

-- antag man betal av samma antal varje månad
set @monthrate=@rate/(100*12);
set @month=@period/30;

set vinst=@month*((power((1+@monthrate), @month))*@amount*@monthrate)/(pow((1+@monthrate),@month)-1)-@amount;

RETURN vinst;
END