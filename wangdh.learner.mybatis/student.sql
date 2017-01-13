USE [MybatisDB]
GO

/****** Object:  Table [dbo].[tb_student]    Script Date: 2017/1/13 11:57:13 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tb_student](
	[Id] [varchar](36) NOT NULL,
	[name] [nvarchar](128) NOT NULL,
	[email] [varchar](128) NOT NULL,
	[birthday] [date] NOT NULL,
 CONSTRAINT [PK_tb_student] PRIMARY KEY (id))
GO

SET ANSI_PADDING OFF
GO












