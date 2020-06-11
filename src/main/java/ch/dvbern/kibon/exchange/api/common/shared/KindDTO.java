/*
 * Copyright (C) 2020 DV Bern AG, Switzerland
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
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class KindDTO implements Serializable {

	private static final long serialVersionUID = 1600984319369985504L;

	@Nonnull
	private @Size(min = 1) @NotNull String vorname;

	@Nonnull
	private @Size(min = 1) @NotNull String nachname;

	@Nonnull
	private @NotNull LocalDate geburtsdatum;

	public KindDTO() {
		this.vorname = "";
		this.nachname = "";
		this.geburtsdatum = LocalDate.MIN;
	}

	public KindDTO(@Nonnull String vorname, @Nonnull String nachname, @Nonnull LocalDate geburtsdatum) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		KindDTO kind = (KindDTO) o;

		return getVorname().equals(kind.getVorname()) &&
			getNachname().equals(kind.getNachname()) &&
			getGeburtsdatum().equals(kind.getGeburtsdatum());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getVorname(), getNachname(), getGeburtsdatum());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", KindDTO.class.getSimpleName() + '[', "]")
			.add("vorname='" + vorname + '\'')
			.add("nachname='" + nachname + '\'')
			.add("geburtsdatum=" + geburtsdatum)
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

	@Nonnull
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(@Nonnull LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
}
