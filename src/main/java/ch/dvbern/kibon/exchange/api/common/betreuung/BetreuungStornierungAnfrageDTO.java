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

package ch.dvbern.kibon.exchange.api.common.betreuung;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class BetreuungStornierungAnfrageDTO implements Serializable {

	private static final long serialVersionUID = 4875118415422697381L;

	@Schema(description = "Eindeutige kiBon Referenz Nummmer\n\nSetzt sich zusammen aus JAHR.FALL.GEMEINDE.KIND.BETREUUNG")
	@Nonnull
	private @Size(min = 1) @NotNull String refnr;

	@Nonnull
	private @Size(min = 1) @NotNull String institutionId;


	public BetreuungStornierungAnfrageDTO() {
		this.institutionId = "";
		this.refnr = "";
	}

	public BetreuungStornierungAnfrageDTO(
		@Nonnull String refNr,
		@Nonnull String institutionId
	) {
		this.refnr = refNr;
		this.institutionId = institutionId;
	}

	@Nonnull
	public String getRefnr() {
		return this.refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public String getInstitutionId() { return this.institutionId; }

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		BetreuungStornierungAnfrageDTO adresse = (BetreuungStornierungAnfrageDTO) o;

		return getRefnr().equals(adresse.getRefnr()) &&
			getInstitutionId().equals(adresse.getInstitutionId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRefnr(), getInstitutionId());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungStornierungAnfrageDTO.class.getSimpleName() + '[', "]")
			.add("institutionId=" + institutionId)
			.add("refnr=" + refnr)
			.toString();
	}

}
