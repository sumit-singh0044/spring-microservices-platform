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
