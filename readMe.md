# Indirection Principle 

## Overview
Indirection is a GRASP (General Responsibility Assignment Software Pattern) principle that helps in **decoupling classes** by introducing an intermediary layer. This makes the system more flexible and easier to modify.

## Without Indirection Principle
In the **without principle** example, `StudentService` directly manages student data using an `ArrayList`. If we ever want to switch from `ArrayList` to a database, we will have to modify `StudentService`, which is not a good design.

### Issues:
- `StudentService` handles both **business logic** and **data storage**.
- If we want to change the storage method (e.g., use a database), we have to modify `StudentService`.
- Hard to maintain and extend.

## With Indirection Principle
In the **with principle** example, we introduce a **StudentDAO interface** and a **StudentDAOImpl class**. The `StudentService` now interacts with the `StudentDAO` instead of directly managing data storage. This **separates concerns** and makes it easy to switch data storage without modifying `StudentService`.

### Benefits:
- `StudentService` only deals with **business logic**, while `StudentDAOImpl` handles **data storage**.
- If we change the storage method (e.g., use a database instead of a list), we only modify `StudentDAOImpl`, not `StudentService`.
- Easier to maintain and extend.

## Summary
| Feature            | Without Indirection              | With Indirection                                 |
|------------------- |-------------------               |-----------------                                 |
| Data Handling      | Managed inside `StudentService`  | Handled by `StudentDAO`                          |
| Flexibility        | Hard to change storage method    | Easy to switch storage (e.g.,List→ Database)    |   
| Code Maintenance   | Difficult                        | Easier                                           |

By using **Indirection**, we make our system **more modular, flexible, and easier to maintain**.


