CREATE DATABASE home_management;

-- Create Queries 
CREATE TABLE family_members (
    id int auto_increment primary key,
    name varchar(30) not NULL,
    surname varchar(30) not null,
    age tinyint not null,
    gender enum('f', 'm'),
    salary decimal(6 , 2 ),
    family_role char(15) not null
);

CREATE TABLE taxes (
    id int auto_increment primary key,
    tax_name varchar(45) not null
);

CREATE TABLE taxes_debt (
    id int auto_increment primary key,
    month tinyint not null,
    debt decimal(6 , 2 ) not null,
    isPaid boolean default false,
    taxes_id int,
    constraint foreign key (taxes_id)
        references taxes (id)
);

CREATE TABLE items (
    id int auto_increment primary key,
    item_name varchar(45) not null,
    item_type varchar(45),
    item_price decimal(6 , 2 ),
    bought_at datetime default current_timestamp,
    is_available boolean default true
);

CREATE TABLE income_expense (
    id int auto_increment primary key,
    income decimal(6 , 2 ),
    expense decimal(6 , 2 ),
    result decimal(6 , 2 ),
    income_expense_month tinyint
);

 -- Select Queries
SELECT 
    id, name, surname, age, gender, salary, family_role
from
    family_members;

desc family_members;

select 
    *
from
    family_members
where
    id = 5;

SELECT 
    id, name, surname, age, gender, salary, family_role
from
    family_members
where
    age > 20;

select 
    *
from
    taxes;

SELECT 
    id,
    item_name,
    item_type,
    item_price,
    bought_at,
    is_available
FROM
    home_management.items;

select 
    id,
    item_name,
    item_type,
    item_price,
    bought_at,
    is_available
from
    items
where
    month(bought_at) = 12;

SELECT 
    id, income, expense, result, income_expense_month
FROM
    income_expense;

select 
    *
from
    taxes_debt;

select 
    taxes_debt.id,
    taxes_debt.month,
    taxes_debt.debt,
    taxes_debt.isPaid,
    taxes.id tax_id,
    taxes.tax_name
from
    taxes_debt
        inner join
    taxes ON taxes.id = taxes_debt.taxes_id;



-- Alter Queries
alter table income_expense
modify column income_expense_month tinyint;

alter table taxes_debt 
modify column month tinyint;

alter table income_expense
drop column result_percentage;

 -- insert into queries
INSERT INTO family_members(name,surname,age,gender,salary,family_role) VALUES (?,?,?,?,?,?);

-- delete queries
delete from taxes_debt;
