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

package ch.dvbern.kibon.exchange.api.common.fileexport;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.institution.InstitutionDTO;
import ch.dvbern.kibon.exchange.api.common.betreuung.BetreuungsAngebot;

public class FileBetreuungDTO implements Serializable {
	private static final long serialVersionUID = 5848170812429419674L;

	@Nonnull
	private @NotNull BetreuungsAngebot betreuungsArt;

	@Nonnull
	private @NotNull @Valid InstitutionDTO institution;

	public FileBetreuungDTO() {
		this.betreuungsArt = BetreuungsAngebot.KITA;
		this.institution = new InstitutionDTO();
	}

	public FileBetreuungDTO(@Nonnull BetreuungsAngebot betreuungsArt, @Nonnull InstitutionDTO institution) {
		this.betreuungsArt = betreuungsArt;
		this.institution = institution;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		FileBetreuungDTO betreuung = (FileBetreuungDTO) o;

		return getBetreuungsArt() == betreuung.getBetreuungsArt() &&
			getInstitution().equals(betreuung.getInstitution());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBetreuungsArt(), getInstitution());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", FileBetreuungDTO.class.getSimpleName() + '[', "]")
			.add("betreuungsArt=" + betreuungsArt)
			.add("institution=" + institution)
			.toString();
	}

	@Nonnull
	public BetreuungsAngebot getBetreuungsArt() {
		return betreuungsArt;
	}

	public void setBetreuungsArt(@Nonnull BetreuungsAngebot betreuungsArt) {
		this.betreuungsArt = betreuungsArt;
	}

	@Nonnull
	public InstitutionDTO getInstitution() {
		return institution;
	}

	public void setInstitution(@Nonnull InstitutionDTO institution) {
		this.institution = institution;
	}
}

