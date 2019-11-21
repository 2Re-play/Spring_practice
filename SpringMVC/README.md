# SPRING
## Spring MVC


### Spring MVC Architecture

(Spring Architecture 이미지)  

Spring MVC 프레임워크를 사용해서 개발을 진행하면 위와 같은 기본적인 구조를 가지게된다.  
request가 들어오면 제일 먼저 servlet을 거치게된다.  
servlet에서 Handler Mapping을 통해 해당 로직을 처리하는 controller로 mapping한다.
controller에서는 비즈니스 로직을 수행하기 위해 Dao로 부터 Data를 받아 Model 객체에 Data 저장 후 비즈니스 로직을 수행하고 servlet에 전달한다.  

