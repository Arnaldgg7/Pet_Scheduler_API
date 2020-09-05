# Pet_Scheduler_API
An API service using a MySQL Database that implements a data model capable for scheduling appointments and be used as an interface for pet's small companies.

This is an implementation of the data model for Critter Chronologer, a Software as a Service application that provides a scheduling interface for small businesses that take care of animals. This enterprise project allows users to create schedules that associate pets, owners, and employees with calendar events.

It is configured to be connected to an external MYSQL Database and uses both JDBC and Hibernate to persist changes to it. Basic CRUD operations are exposed via REST controller layer, as well as a bunch of common interactions in JSON formal with the database using Postman. It is initially configured to use the built-in CRUD Operations that JAVA Spring Data JPA provides, although it can be easily improved using more precise Hibernate and EntityManager operations, or even matching specific queries in SQL by means of JDBC to gain efficiency when needed.
