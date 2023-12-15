## Mock API

For testing purpose when using production integration is impossible.
Complex services with obtaining test data

SUT App send request to Mock-Service and get static **preconfigured** response.

- Fake it until you make it;
- Simulate APIs that don't exist yet
- SetUp happy Path response;
- SetUp negative Path response;
- Create stable isolated test environment;
- Test flaky 3rd parties;
- Test unstable or complex-data services;

Mockito / PowerMock => create complex Java object within unit test;
WireMock => setting up stable test environment;

### 2 ways to create stub:

- 1- register stub from WireMock instance by **register()** method; | setting up more than one stub
- 2- use static DSL chain methods within **stubFor()** method; | only one stub possible

### InMemoryMock

InMemoryMock - work in test environment in current Java thread;

* Set Up one or more Mock Service
  @RegisterExtension
  static WireMockExtension wireMockExtension = new WireMockExtension .Builder().options(options().port(8080)).build();

* create @BeforeEach method with configuration of the stub

### StandaloneMock

StandAloneMock - work within Java thread, from Docker run.

* Crete JsonStub file with preconditions
* Up and Run WireMock image in Docker by **docker.mock.yaml**
* set volumes -> JsonStub file
* set ports


* For more details visit - https://wiremock.org/docs/