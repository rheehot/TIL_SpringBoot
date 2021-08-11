package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 회원 등록, 비영속상태
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            // 영속상태
            em.persist(member);
            /* 회원 조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());*/

            /* 회원 삭제
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);*/

            /* 회원 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/

            /**
             * JPQL
             * - 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
             * - SQL을 추상화해서 특정 데이터베이스 SQL에 의존 x
             * - JPQL을 한마디로 정의하면 객체 지향 SQL
             */
            /*
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member1 : result) {
                System.out.println("member1.name = " + member1.getName());
            }*/
            
            // 영속 엔티티의 동일성 보장
            Member findMember1 = em.find(Member.class, 1L);
            Member findMember2 = em.find(Member.class, 1L);

            System.out.println("result = " + (findMember1 == findMember2));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
