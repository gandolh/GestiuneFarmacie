UPDATE [dbo].[FarmacieUser]
   SET [username] = ?
   ,[email] = ?
 WHERE  id= ?


 UPDATE [dbo].[Employee]
   SET [firstname] =  ?
      ,[lastname] = ?
      ,[birthdate] = convert(datetime, ?, 5)
      ,[hiredate] = convert(datetime, ?, 5)
 WHERE id= ?
