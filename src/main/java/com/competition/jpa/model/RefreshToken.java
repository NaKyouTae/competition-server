package com.competition.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "REFRESHTOKEN")
public class RefreshToken implements Serializable {

	private static final long serialVersionUID = 4368682883404823822L;

	@Id
	@Column
	private String userName;

	@Column
	private String token;
}
