CREATE TABLE [dbo].[unit_station_details](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[UnitCode] [varchar](50) NULL,
	[StationNumber] [varchar](50) NULL,
 CONSTRAINT [UK_unit_station_details] UNIQUE(UnitCode,StationNumber),
 CONSTRAINT [PK_unit_station_details] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]  



CREATE TABLE [dbo].[plant_station_details](
	[id] [varchar](255) NOT NULL,
	[plant_code] [varchar](255) NULL,
	[station_name] [varchar](255) NULL,
	[station_number] [varchar](255) NULL,
	[station_version] [varchar](255) NULL,
	[status] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



CREATE TABLE [dbo].[can_hw](
	[id] [varchar](255) NOT NULL,
	[alias_name] [varchar](255) NULL,
	[can_device] [int] NULL,
	[channel_index] [int] NULL,
	[channel_name] [varchar](255) NULL,
	[hw_index] [int] NULL,
	[hw_type] [int] NULL,
	[plant_station_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



CREATE TABLE [dbo].[config_setting](
	[id] [varchar](255) NOT NULL,
	[cs_key] [varchar](255) NULL,
	[plant_station_id] [varchar](255) NULL,
	[value] [varchar](255) NULL,
	[value2] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



CREATE TABLE [dbo].[jdtester_hw](
	[id] [varchar](255) NOT NULL,
	[bit_offset] [int] NULL,
	[block_offset] [int] NULL,
	[bulk_head_pin] [varchar](255) NULL,
	[connector] [varchar](255) NULL,
	[description] [varchar](255) NULL,
	[flex_box_pin] [varchar](255) NULL,
	[fuses_relays] [varchar](255) NULL,
	[hw_name] [varchar](255) NULL,
	[plant_station_id] [varchar](255) NULL,
	[pull_up] [varchar](255) NULL,
	[pwm] [varchar](255) NULL,
	[raw_maximum] [int] NULL,
	[raw_minimum] [int] NULL,
	[scaled_maximum] [int] NULL,
	[scaled_minimum] [int] NULL,
	[scaling_factor] [int] NULL,
	[scaling_offset] [int] NULL,
	[tla] [varchar](255) NULL,
	[type_code] [varchar](255) NULL,
	[um] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

