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

package ch.dvbern.kibon.exchange.api.common.tagesschule.anmeldung;

import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.KindDTO;

public class TagesschuleKindDTO extends KindDTO {

	private static final long serialVersionUID = 3946921345407749881L;

	@NotNull
	@Nonnull
	private Geschlecht geschlecht;

	public TagesschuleKindDTO() {
		geschlecht = Geschlecht.WEIBLICH;
	}

	public TagesschuleKindDTO(
		@Nonnull String vorname,
		@Nonnull String nachname,
		@Nonnull LocalDate geburtsdatum,
		@Nonnull Geschlecht geschlecht) {
		super(vorname, nachname, geburtsdatum);
		this.geschlecht = geschlecht;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TagesschuleKindDTO)) {
			return false;
		}

		if (!super.equals(o)) {
			return false;
		}

		TagesschuleKindDTO that = (TagesschuleKindDTO) o;

		return getGeschlecht() == that.getGeschlecht();
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getGeschlecht());
	}

	@Nonnull
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(@Nonnull Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
}
