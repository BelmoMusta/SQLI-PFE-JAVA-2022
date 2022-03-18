package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sqli.authentification.entitie.Group;

@Repository
public interface GroupDao extends JpaRepository<Group, Integer> {
}
