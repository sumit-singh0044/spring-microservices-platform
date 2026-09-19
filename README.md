# How to Push an Existing Project to GitHub

## Step 1: Create a Repository on GitHub

1. Sign in to GitHub.
2. Click the **+** icon (top-right) → **New repository**.
3. Enter a repository name.
4. Choose **Public** or **Private**.
5. **Do not** initialize the repository with:
   - README
   - .gitignore
   - License
6. Click **Create repository**.

## Step 2: Open Git Bash

Navigate to your project directory.

```bash
cd path/to/your/project
```

Example:

```bash
cd C:/Users/Sumit/Desktop/SpringBootProject
```

## Step 3: Initialize Git

```bash
git init
```

## Step 4: Check the Repository Status

```bash
git status
```

## Step 5: Add All Files

```bash
git add .
```

## Step 6: Commit the Changes

```bash
git commit -m "Initial commit"
```

## Step 7: Rename the Branch to `main`

```bash
git branch -M main
```

## Step 8: Add the Remote Repository

Replace `<repository-url>` with your GitHub repository URL.

```bash
git remote add origin <repository-url>
```

Example:

```bash
git remote add origin https://github.com/your-username/your-repository.git
```

## Step 9: Verify the Remote

```bash
git remote -v
```

## Step 10: Push the Project to GitHub

```bash
git push -u origin main
```

After the first push, future pushes only require:

```bash
git push
```

Future pulls only require:

```bash
git pull
```



# Redis

Redis is an **in-memory key-value data store**.

It is commonly used for:

* Caching
* Rate limiting
* Session storage
* Counters
* Temporary data
* Distributed locking

## Running Redis with Docker

Make sure Docker Desktop is running.

Start Redis:

```bash
docker run --name redis -p 6379:6379 -d redis
```

Check if Redis is running:

```bash
docker ps
```

Redis will be available on:

```text
localhost:6379
```

Open Redis CLI:

```bash
docker exec -it redis redis-cli
```
## Basic Commands

### SET

Store data:

```text
SET name Sumit
```

### GET

Retrieve data:

```text
GET name
```

Output:

```text
"Sumit"
```

### DEL

Delete data:

```text
DEL name
```

### KEYS

See stored keys:

```text
KEYS *
```

> **Note:** `KEYS *` is useful for learning, but should be avoided in production with large datasets.

## Expiration

### EXPIRE

Set expiration time in seconds:

```text
SET name Sumit
EXPIRE name 30
```

The key will automatically be deleted after 30 seconds.

You can also set expiration while creating the key:

```text
SET name Sumit EX 30
```

### TTL

Check the remaining expiration time:

```text
TTL name
```

Example:

```text
(integer) 25
```

This means approximately **25 seconds** are remaining.

## Counters

### INCR

Increase a number by 1:

```text
SET counter 10
INCR counter
```

Output:

```text
(integer) 11
```

If the key doesn't exist, Redis creates it:

```text
INCR counter
```

Result:

```text
(integer) 1
```

### DECR

Decrease a number by 1:

```text
DECR counter
```

## Basic Commands to Remember

| Command  | Purpose                    |
| -------- | -------------------------- |
| `SET`    | Store data                 |
| `GET`    | Retrieve data              |
| `DEL`    | Delete data                |
| `KEYS *` | View keys                  |
| `EXPIRE` | Set expiration             |
| `TTL`    | Check remaining expiration |
| `INCR`   | Increase a number          |
| `DECR`   | Decrease a number          |


