# SPRING
## Spring JDBC


### Data access layer
- JDBC class : spring-jdbc
- JDBC diver : mysql-connector-java
- data source : commons-dbcp2
를 사용하기 위해서는 pom.xml에서 maven을 통해 필요한 라이브러리를 다운로드 받는다.

### data souce에 DB config 설정
- data source는 interface다!
- apache에서 제공하는 commons-dbcp 라이브러리를 사용하자.
- 여기서 우리는 BasicDataSource class를 사용한다.
-> 해당 클래스에서 **DB connection pool**을 제공한다.
    - **DB connection pool**은 미리 connection을 수행한 thread를 미리 만들어둔다.
    - 요청이 들어오면 thread를 빌려주고 작업을 수행한 후 다시 반납하며 thread를 재사용한다.
    - pool에서 수행할 수 있는 thread가 없는 경우 요청은 maxWait만큼 wait된다.
    - pool을 사용하지 않으면 connection thread를 계속해서 요청마다 생성하고 제거하는 작업을 반복하며 overhead가 발생한다. 성능 저하!
- data source config를 설정하고 bean 등록하게 되면 spring container가 bean을 생성한다.

## DAO
- DB에 CRUD관련 인터페이스를 제공하는 interface.
- Application Service Object와 DataBase 사이에서 동작한다

-  @Component("클래스이름") 어노테이션으로 bean을 생성한다.
```java
@Component("offersDao") // offersDao 클래스의 bean 생성 어노테이션, scope = singleton
public class OffersDao {
    
    private JdbcTemplate jdbcTemplateObject;
    
    @Autowired
    public void setDataSource(DataSource dataSource) { // DI
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    ... (CRUD 기능 method 생략)
}
```

## Plain JDBC vs Spring JDBC

### Plain JDBC
- 예외처리 코드와 DB connection 관련 코드를 **반드시** 작성해야한다.
- 이러한 같은 코드가 계속해서 반복된다는 단점이 있다.

```java
public class PlainJDBC {
    public void GettingRows() {
        Connection conn = null;
        Statement stmt = null;
        Resultset rset = null;
    
       try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement (); 
            rset = stmt.executeQuery ("select count(*) from customers");
            while (rset.next()) {
           count = rs.getInt(1);
            }
    
       } catch (SQLException e) {
        LOGGER.error(e); throw e;
        }
       finally {
                 //code to clean up resources
       }
   }
}


```

### Spring JDBC
- plain JDBC와 같이 detail 부분에 low-level로 다룰 수 있다.
- 왜냐하면 Spring JDBC가 처리해주기 때문이다.
- 개발자는 비즈니스 로직에만 집중할 수 있다.
```java
@Repository
public class SpringDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
     public void setDataSource(DataSource dataSource) {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
     }

     public int getCustomerCount() {
         return jdbcTemplate.queryForInt("select count(*) from customers");
     }
}
```

## JdbcTemplate을 사용하여 sql 수행하기

- SQL query를 수행하기 위해서 jdbcTemplate객체의 query method를 사용하여 sql을 수행한다.
```java
@Component("offersDao") // bean 생성
public class OffersDao {
    
    private JdbcTemplate jdbcTemplateObject;
    
    @Autowired // 의존성주입
    public void setDataSource(DataSource dataSource) { 
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    public List<Offer> getOffers () {
        
        return jdbcTemplateObject.query('select * from offers', new RowMapper<Offer>() {
            
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();
                
                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setText(rs.getString("text"));
                offer.setEmail(rs.getString("email"));
                
                return offer;
            }
            
        });
    }
}
```
- query method안에서 파리미터로 첫번째 인자는 sql문, 두번째 인자는 결과값을 mapping할 함수
- RowMapper는 interface인데 앞에 왜 new가 붙어있을까? (인터페이스 객체를 생성할 수 없음)
- 왜냐하면 익명클래스이기 때문에 앞에 new 키워드가 붙는다.
- mapRow() method를 통해 쿼리의 결과값으로 넘어온 값들을 객체로 mapping한다.

#### @Component() 어노테이션

- 어노테이션의 인자로 넣은 이름의 bean을 xml 설정없이 자동 생성한다.









