# osu!api Wrapper for Java

This is an open source Java API wrapper for the [osu!api](http://osu.ppy.sh/api), the public API of
[the game osu!](http://osu.ppy.sh).

**Compatible osu!api version:** [1.0](https://github.com/peppy/osu-api/wiki)

## Installation

This project uses [Apache Maven](https://maven.apache.org/) for build automation and dependency management.
Unfortunately this project is not available in any repository so it is needed to install it locally. A functioning maven
installation is required.

 1. Clone the repository: `git clone https://github.com/osuWorks/osu-api-Java-Client.git`
 2. Switching into the repository directory: `cd osu-api-Java-Client`
 3. Trigger maven goals: `mvn clean install`

After a successful build you can use the components:

for API common utils (models, serializers, ...):
```
<dependency>
    <groupId>de.maxikg</groupId>
    <artifactId>osu-apiwrapper-common</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

for the API client:
```
<dependency>
    <groupId>de.maxikg</groupId>
    <artifactId>osu-apiwrapper-client</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Usage

Coming soon.

If you are a Java developer you can browse the repository to get familiar with the osu!api Java Client.

## License

See [LICENSE.md](./LICENSE.md).

## Contribution

See [CONTRIBUTE.md](./CONTRIBUTE.md).

## Links

 * [The game osu!](http://osu.ppy.sh)
 * [osu!api Documentation](https://github.com/peppy/osu-api/wiki)