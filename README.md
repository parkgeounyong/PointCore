# Point Core (DDD Sample Project)
DDD 아키텍쳐에 대한 테스트 및 포인트 결제에 대한 기본 구조 학습용 프로젝트
## 배운점
- 포인트 적립 및 사용의 기본 흐름 이해
- DDD(Domain-Driven Design) 구조 학습
- DDD 구조의 장단점
  - 장점: 명확한 계층 분리로 각 기능을 체계적으로 작성 가능, 규칙성이 강제됨
  - 단점: 작은 기능에도 파일 수가 많아 피로도가 상승, 루트 엔티티를 사용하려면 JPA Many-to-One 관계 활용 필요

## 🏛️ 프로젝트 구조 (DDD & 헥사고날 아키텍처)

프로젝트는 크게 `user`와 `point` 두 개의 도메인으로 나뉘어 있으며, 각 도메인은 DDD의 계층형 아키텍처를 따릅니다.

```
src
└── main
    └── kotlin
        └── io/github/parkgeounyong/point_core
            ├── point/
            │   ├── application/  # 애플리케이션 계층 (Use Cases)
            │   ├── domain/       # 도메인 계층 (Entities, Repositories Interfaces)
            │   ├── infrastructure/ # 인프라스트럭처 계층 (Frameworks, DB)
            │   └── presentation/   # 프레젠테이션 계층 (Controllers)
            └── user/
                ├── application/
                ├── domain/
                ├── infrastructure/
                └── presentation/
```

-   **`domain`**: 순수한 비즈니스 로직과 규칙을 담고 있는 핵심 계층입니다. 다른 계층에 대한 의존성이 없으며, 오직 비즈니스에만 집중합니다.
    -   `model`: 도메인 객체 (Entity, VO)
    -   `repository`: 도메인 객체를 영속성 처리하기 위한 인터페이스
-   **`application`**: `domain` 계층의 로직을 조합하여 실제 응용 서비스를 제공하는 계층입니다. UseCase를 구현하며, 트랜잭션 관리 등을 담당합니다.
-   **`presentation`**: 외부(클라이언트)와 상호작용하는 계층입니다. RESTful API 엔드포인트를 제공하고, 사용자의 요청을 `application` 계층으로 전달합니다.
-   **`infrastructure`**: 데이터베이스, 외부 API 연동 등 외부 기술과 관련된 구체적인 구현을 담당하는 계층입니다. `domain` 계층의 리포지토리 인터페이스를 구현합니다.

## ✨ 주요 기술 스택

-   **Language**: Kotlin
-   **Framework**: Spring Boot 3.x
-   **ORM**: Spring Data JPA
-   **Build Tool**: Gradle (Kotlin DSL)
-   **Database**: Docker를 이용한 RDBMS (PostgreSQL)
