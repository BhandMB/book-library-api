# Local Development Checklist

- Read the README and confirm the required JDK, build tool, and database versions.
- Configure local connection details outside committed source files.
- Start the database and verify the application can connect before debugging endpoint failures.
- Run the project test suite before making changes.
- Exercise the documented endpoints with both valid and invalid input.
- Check application logs for actionable errors while avoiding the publication of secrets.
- Update setup instructions when dependencies, configuration keys, or startup commands change.
