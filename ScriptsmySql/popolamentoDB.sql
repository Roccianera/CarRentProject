/***Per visualizzare le varie tabelle****/
select * from auto;
select * from optionalauto;
select * from noleggiauto;
select * from optionalauto_has_noleggiauto;
select * from serviziassicurativi;
select * from utentiregistrati;

/***Inserimenti nella tabella AUTO**/
insert into auto values(1,"AB 456CD",4,260,"benzina",69,true,0);
insert into auto values(2,"EW 902DZ",4,216,"benzina",82,true,1);
insert into auto values(3,"EX 180AY",4,270,"gasolio",100,true,2);

/***Inserimenti nella tabella OPTIONALAUTO**/
insert into optionalauto values(1,"wifi in auto",20);
insert into optionalauto values(2,"cruise control adattivo",50);
insert into optionalauto values(3,"Fari Full LED",45);
insert into optionalauto values(4,"Connettività Bluetooth",20);
insert into optionalauto values(5,"Sistema Keyless",19.99);
insert into optionalauto values(6,"Sedili riscaldati",10.99);

/***Inserimento nella tabella SERVIZIASSICURATIVI****/
insert into serviziassicurativi values(1,"Polizza furto e incendio",140);
insert into serviziassicurativi values(2,"Polizza cristalli",130);
insert into serviziassicurativi values(3,"Polizza infortuni al conducente",150);
insert into serviziassicurativi values(4,"Riduzione della franchigia",100);
insert into serviziassicurativi values(5,"Polizza Kasko",159.99);

/***Inserimento tabella UTENTIREGISTRATI***/
insert into utentiregistrati values(1,"Dominic","Toretto","fastandfurios@gmail.com",1999,2030,"U1H68I903B");
insert into utentiregistrati values(2,"Valentino","Rossi","valerosso19@gmail.com",2000,2040,"X2Y18I802A");
insert into utentiregistrati values(3,"Mario","Rossi","mariorossi@libero.it",1980,2025,"A5X19A213C");
