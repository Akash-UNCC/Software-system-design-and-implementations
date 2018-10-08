-- Which actors have the first name ‘Scarlett’
-- Which actors have the last name ‘Johansson’
-- How many distinct actors last names are there?
-- Which last names are not repeated?
-- Which last names appear more than once?
-- Which actor has appeared in the most films?
-- Is ‘Academy Dinosaur’ available for rent from Store 1?
-- When is ‘Academy Dinosaur’ due?
-- What is that average running time of all the films in the sakila DB?
-- What is the average running time of films by category?


Use sakila;

select count(*) from actor;
-- Which actors have the first name ‘Scarlett’
select * from actor where first_name = 'Scarlett';
-- Which actors have the last name ‘Johansson’
select * from actor where last_name = 'Johansson';


select count(last_name) from (select distinct last_name from actor) a;
select count(distinct last_name) from actor;

-- Which last names are not repeated?
select last_name from actor group by last_name having count(*) = 1;
select last_name from actor group by last_name having count(last_name) = 1;

-- Which last names appear more than once?

select last_name from actor group by last_name having count(last_name) > 1;
select last_name from actor group by last_name having count(*) > 1;

-- Which actor has appeared in the most films?

select a.*, count(fa.actor_id) as film_count from actor a, film_actor fa where a.actor_id = fa.actor_id group by fa.actor_id
order by film_count desc limit 1;

-- Is ‘Academy Dinosaur’ available for rent from Store 1?
select distinct f.title from inventory i, film f where i.film_id = f.film_id and i.store_id = 1 and f.title = 'Academy Dinosaur';

-- What is that average running time of all the films in the sakila DB?
select avg(length) from film; 

-- What is the average running time of films by category?
select fc.category_id, avg(f.length) from film f, film_category fc where f.film_id = fc.film_id group by fc.category_id;
