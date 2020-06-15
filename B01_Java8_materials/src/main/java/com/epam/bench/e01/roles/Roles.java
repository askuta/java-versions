package com.epam.bench.e01.roles;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Roles {

	public Set<Role> getElevatedRoles() {
		return getRoles(role -> role.isElevated());
	}

	public Set<Role> getRolesAboveAccessLevel(int accessLevel) {
		return getRoles(role -> role.getAccessLevel() >= accessLevel);
	}

	public Set<Role> getRolesBelowAccessLevel(int accessLevel) {
		return getRoles(role -> role.getAccessLevel() < accessLevel);
	}

	public Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
		return getRoles(role -> role.isElevated() && role.getAccessLevel() == accessLevel);
	}

	private Set<Role> getRoles(RoleFilter filter) {
		return Arrays.asList(Role.values()).stream().filter(new Predicate<Role>() {
			@Override
			public boolean test(Role role) {
				return filter.accept(role);
			}
		}).collect(Collectors.toSet());
	}
}
