# API Exceptions

The classes in this package are helper Exceptions which were created to assist you. None of the classes in this package should be modified.

These methods leverage the `@ResponseStatus` annotation to associate the Exceptions with a particular status code. These can help you when trying to throw specific codes based on the type of validation problem that should result from your API.

You should import and throw the appropriate Exception as needed.
