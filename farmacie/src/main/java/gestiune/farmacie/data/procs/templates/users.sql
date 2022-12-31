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
        convert(datetime,'18-06-99 10:34:09 PM',5),
        convert(datetime,'18-06-99 10:34:09 PM',5))


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