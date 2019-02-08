CALL `Bankomat`.`CreateNewClient`(1, 19800205, 123456);
CALL `Bankomat`.`UpdateInfo`(1, 'Bao', 'Åkerbyvägen', '072234874');
CALL `Bankomat`.`CreateNewClient`(1, 19800408, 123456);
CALL `Bankomat`.`Delete Client`(1, 2);
CALL `Bankomat`.`AssignAccount`(3, 3, 100100);
CALL `Bankomat`.`AssignAccount`(2, 1, 100102);
CALL `Bankomat`.`EndAccount`(4, 3, 1);
CALL `Bankomat`.`Deposit`(2, 1, 3, 1000);
CALL `Bankomat`.`AssignAccount`(4, 3, 100104);
CALL `Bankomat`.`AssignAccount`(5, 3, 100105);
CALL `Bankomat`.`EndAccount`(3, 3, 5);
CALL `Bankomat`.`Deposit`(2, 3, 4, 1000);
CALL `Bankomat`.`Withdraw`(4, 1, 3, 500);
CALL `Bankomat`.`Withdraw`(2, 3, 4, 1500);
CALL `Bankomat`.`SetAccountRate`(4, 1, 3, 5.7);
CALL `Bankomat`.`SetAccountRate`(5, 1, 3, 3.2);
CALL `Bankomat`.`GrantLoan`(3, 3, 2);
CALL `Bankomat`.`SetLoanRate`(5, 3, 2, 6.3);
CALL `Bankomat`.`ChangeLanPlan`(4, 3, 2, '2021-10-04');
CALL `Bankomat`.`ChangeLanPlan`(4, 1, 1, '2020-10-04');
CALL `Bankomat`.`ClientWithdrawCash`(1, 3, 200);
CALL `Bankomat`.`ClientWithdrawCash`(2, 3, 200);  -- other people can not withdraw from your account
CALL `Bankomat`.`CreateNewClient`(2, 19830205, 123456);
CALL `Bankomat`.`CreateNewClient`(4, 19840205, 123456);
CALL `Bankomat`.`UpdateInfo`(5, 'Xin', 'Åkerbyvägen', '072234884');
CALL `Bankomat`.`Delete Client`(4, 10);
CALL `Bankomat`.`AssignAccount`(2, 3, 100107);
CALL `Bankomat`.`SetAccountRate`(3, 3, 6, 5);
CALL `Bankomat`.`EndAccount`(2, 1, 7);
CALL `Bankomat`.`Deposit`(3, 3, 4, 1000);
CALL `Bankomat`.`Withdraw`(4, 1, 3, 1000);
CALL `Bankomat`.`GrantLoan`(3, 1, 1);
CALL `Bankomat`.`SetLoanRate`(5, 1, 1, 7);
CALL `Bankomat`.`ChangeLanPlan`(4, 3, 2, '2021-07-04');
CALL `Bankomat`.`CreateNewClient`(3, 19780408);
CALL `Bankomat`.`UpdateInfo`(6, 3456,'Chun', 'kerbyvägen', '072224884');
CALL `Bankomat`.`AssignAccount`(3, 1, 100108);
CALL `Bankomat`.`AssignAccount`(2, 1, 100109);
CALL `Bankomat`.`AssignAccount`(2, 3, 100111);
CALL `Bankomat`.`Deposit`(2, 1, 7, 1000);

select PayOffMonth(2) as payoff;
select VinstofLoan(1) as vinst;



call DeleteClient(3,10);
