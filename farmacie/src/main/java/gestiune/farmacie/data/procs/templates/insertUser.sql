INSERT INTO [dbo].[Employee]
        ([id]
		,[firstname]
        ,[lastname]
        ,[birthdate]
        ,[hiredate])
    VALUES(
		?,
        ?,
        ?,
        convert(datetime, ?, 5), -- '18-06-99 10:34:09 PM'
        convert(datetime, ?, 5)) -- '18-06-99 10:34:09 PM'


INSERT INTO [dbo].[FarmacieUser]
           ([id]
           ,[employeeId]
           ,[username]
           ,[hashedPassword])
     VALUES
           (?
           ,?
           ,?
           ,?)