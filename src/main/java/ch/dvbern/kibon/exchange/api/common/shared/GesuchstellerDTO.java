/*
 * Copyright (C) 2019 DV Bern AG, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.dvbern.kibon.exchange.api.common.shared;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GesuchstellerDTO implements Serializable {

	private static final long serialVersionUID = 34206637279247377L;

	@Nonnull
	private @Size(min = 1) @NotNull String vorname;

	@Nonnull
	private @Size(min = 1) @NotNull String nachname;

	@Nullable
	private String email;

	public GesuchstellerDTO() {
		this.vorname = "";
		this.nachname = "";
	}

	public GesuchstellerDTO(@Nonnull String vorname, @Nonnull String nachname, @Nullable String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		GesuchstellerDTO that = (GesuchstellerDTO) o;

		return getVorname().equals(that.getVorname()) &&
			getNachname().equals(that.getNachname()) &&
			Objects.equals(getEmail(), that.getEmail());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getVorname(), getNachname(), getEmail());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", GesuchstellerDTO.class.getSimpleName() + '[', "]")
			.add("vorname='" + vorname + '\'')
			.add("nachname='" + nachname + '\'')
			.add("email='" + email + '\'')
			.toString();
	}

	@Nonnull
	public String getVorname() {
		return vorname;
	}

	public void setVorname(@Nonnull String vorname) {
		this.vorname = vorname;
	}

	@Nonnull
	public String getNachname() {
		return nachname;
	}

	public void setNachname(@Nonnull String nachname) {
		this.nachname = nachname;
	}

	@Nullable
	public String getEmail() {
		return email;
	}

	public void setEmail(@Nullable String email) {
		this.email = email;
	}
}
