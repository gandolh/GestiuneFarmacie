INSERT INTO [dbo].[Employee]
        ([id]
		,[firstname]
        ,[lastname]
        ,[birthdate]
        ,[hiredate])
    VALUES(
		1,
        'admin',
        'admin',
        convert(datetime,'18-06-99 10:34:09 PM',5),
        convert(datetime,'18-06-99 10:34:09 PM',5))

INSERT INTO [dbo].[FarmacieUser]
           ([id]
           ,[employeeId]
           ,[username]
           ,[email]
           ,[hashedPassword])
     VALUES
           (1
           ,1
           ,'admin'
           ,'itmanager@admin.ro'
           ,'$2a$12$PIHoJhEBLgtu9DpqyeABGuMpcPWpREdUvUXsHwTLrYqtZxhDavl82') --admin