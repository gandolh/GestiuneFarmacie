
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Employee' and xtype='U')
    CREATE TABLE Employee (
        id varchar(64) NOT NULL UNIQUE,
		firstname varchar(64),
		lastname varchar(64),
		birthdate Date,
		hiredate Date
    )

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='FarmacieUser' and xtype='U')
    CREATE TABLE FarmacieUser (
        id varchar(64) NOT NULL UNIQUE,
		employeeId varchar(64),
		username varchar(64),
		hashedPassword varchar(256),
     FOREIGN KEY (employeeId) REFERENCES Employee(id)
	)

	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='UserRole' and xtype='U')
    CREATE TABLE UserRole (
        id varchar(64) NOT NULL UNIQUE,
		value varchar(64),
		userId varchar(64) NOT NULL,

     FOREIGN KEY (userId) REFERENCES FarmacieUser(id)
	)


	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='UserPermissions' and xtype='U')
    CREATE TABLE UserPermissions (
        id varchar(64) NOT NULL UNIQUE,
		value varchar(64),
		roleId varchar(64),
     FOREIGN KEY (roleId) REFERENCES UserRole(id)
	)

			IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='MedicineCategory' and xtype='U')
    CREATE TABLE MedicineCategory (

	id varchar(64) NOT NULL UNIQUE,
	titlu varchar(64),
	descr varchar(64)


	)


			IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='ProviderFarmacie' and xtype='U')
    CREATE TABLE ProviderFarmacie (
       cui varchar(64) NOT NULL UNIQUE,
	   denumire varchar(64),
	   adresa varchar(64),
	   nrRegCom int,
	   telefon varchar(64),
	   codPostal varchar(64),
	   iban varchar(64),
	   dataInregistrare datetime,
	   codCAEN int,
	   email varchar(64)

	)


	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Comentarii' and xtype='U')
    CREATE TABLE Comentarii (

	id varchar(64) NOT NULL UNIQUE,
	titlu varchar(64),
	descr varchar(64)


	)



	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Medicine' and xtype='U')
    CREATE TABLE Medicine (

	id varchar(64) NOT NULL UNIQUE,
	valueMed int,
	stockCount int,
	categorie varchar(64),
	providerMed varchar(64),
	comentarii varchar(64)


	FOREIGN KEY (providerMed) REFERENCES ProviderFarmacie(cui),
	FOREIGN KEY (categorie) REFERENCES MedicineCategory(id),
	FOREIGN KEY (comentarii) REFERENCES Comentarii(id)

	)

		IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='OrderMed' and xtype='U')
    CREATE TABLE OrderMed (

	id varchar(64) NOT NULL UNIQUE,
	dataCumparare datetime,
	medicament varchar(64)

		FOREIGN KEY (medicament) REFERENCES Medicine(id)



	)
			IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='StockRequest' and xtype='U')
    CREATE TABLE StockRequest (

	id varchar(64) NOT NULL UNIQUE,
	dataCumparare datetime,
	medicament varchar(64)

		FOREIGN KEY (medicament) REFERENCES Medicine(id)



	)

		IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Issue' and xtype='U')
    CREATE TABLE Issue (


	titlu varchar(64),
	descriere varchar(64),
	recipient varchar(64),
	isuser varchar(64)

	FOREIGN KEY (isuser) REFERENCES FarmacieUser(id)


	)
	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Client' and xtype='U')
    CREATE TABLE Client (

	id varchar(64) NOT NULL UNIQUE,
	firstName varchar(64),
	lastName varchar(64),
	birthdate datetime,
	cnp varchar(64)



	)

			IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Bonuses' and xtype='U')
    CREATE TABLE Bonuses (

	salaryId varchar(64) NOT NULL UNIQUE,
	value int,
	title varchar(64),
	description varchar(64)


	)

	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Salary' and xtype='U')
    CREATE TABLE Salary (

	id varchar(64) NOT NULL UNIQUE,
	value int,
	userMed varchar(64),
	bonuses varchar(64)


		FOREIGN KEY (bonuses) REFERENCES Bonuses(salaryId),
		FOREIGN KEY (userMed) REFERENCES FarmacieUser(id)



	)

	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Promotions' and xtype='U')
    CREATE TABLE Promotions (

		cod int,
		valueMed decimal(2),
		medicineId varchar(64),
		active bit

	FOREIGN KEY (MedicineId) REFERENCES Medicine(id)


    )

		IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='PlatformSettings' and xtype='U')
    CREATE TABLE PlatformSettings (

	GetProviderData varchar(64),
	GetUserData varchar(64),
	SMPTPUsername varchar(64),
	SMPTPPassword varchar(64),
	SMPTPProtocol int


    )
