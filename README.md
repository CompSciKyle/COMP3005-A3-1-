## How to Run

### 1. Set Up the Database
1. Open PostgreSQL using pgAdmin.
2. Create a database and run the provided `setup.sql` file to create the `students` table and insert the initial data.

### 2. Configure Environment Variables
1. Copy `.env.example` and rename the copy to `.env`.
2. Open `.env` and enter your PostgreSQL connection details:

   ```env
   DB_URL=jdbc:postgresql://127.0.0.1:5433/YOUR_DATABASE_NAME
   DB_USER=YOUR_USERNAME
   DB_PASSWORD=YOUR_PASSWORD
   ```

3. Save the `.env` file in the project's root directory.

### 3. Connect to OpenStack (If Applicable)
1. Connect to the Carleton VPN.
2. Start your OpenStack VM.
3. Open a terminal and run:

   ```bash
    ssh -N -L 5433:127.0.0.1:5432 student@<floating-ip>
This command creates a secure SSH tunnel through port 22, allowing the Java application to connect to the PostgreSQL database on the VM through local port 5433, which forwards traffic to port 5432.

### Video Link:
[https://youtu.be/dNbiCVMd3e8]
