# Contentful Example

## Backend application

Start the app via the command line running the following command.

```shell
$ ./gradlew :contentful-backend:bootRun
```

Go to http://localhost:8080/graphiql and execute the example queries below:

```graphql
{
    entityById(id: "461ccba0-fd5e-4f89-923f-c75b7d14cb71") {
        id
        name
        type
    }
    entityByName(name: "Jane Doe") {
        id
        name
        type
    }
}
```