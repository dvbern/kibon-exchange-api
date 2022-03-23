/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.tagesschule;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class TagesschuleModuleDTO implements Serializable {

	private static final long serialVersionUID = -6706370215065622002L;

	@Schema(description = "Die ID der Institution, für welche die Module definiert wurden.")
	@Size(min = 1)
	@NotNull
	@Nonnull
	private String institutionId = "";

	@Schema(description = "Start des Schuljahr Periode, e.g. 2020-08-01")
	@NotNull
	@Nonnull
	private LocalDate periodeVon = LocalDate.MIN;

	@Schema(description = "Ende der Schuljahr Periode, e.g. 2021-07-31")
	@NotNull
	@Nonnull
	private LocalDate periodeBis = LocalDate.MIN;

	@NotNull
	@Valid
	@Nonnull
	private List<ModulDTO> module = new ArrayList<>();

	public TagesschuleModuleDTO() {
	}

	public TagesschuleModuleDTO(
		@Nonnull String institutionId,
		@Nonnull LocalDate periodeVon,
		@Nonnull LocalDate periodeBis,
		@Nonnull List<ModulDTO> module) {
		this.institutionId = institutionId;
		this.periodeVon = periodeVon;
		this.periodeBis = periodeBis;
		this.module = module;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TagesschuleModuleDTO)) {
			return false;
		}

		TagesschuleModuleDTO that = (TagesschuleModuleDTO) o;

		return getInstitutionId().equals(that.getInstitutionId())
			&& getPeriodeVon().equals(that.getPeriodeVon())
			&& getPeriodeBis().equals(that.getPeriodeBis())
			&& getModule().equals(that.getModule());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getInstitutionId(), getPeriodeVon(), getPeriodeBis(), getModule());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", TagesschuleModuleDTO.class.getSimpleName() + '[', "]")
			.add("institutionId='" + institutionId + '\'')
			.add("periodeVon=" + periodeVon)
			.add("periodeBis=" + periodeBis)
			.toString();
	}

	@Nonnull
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Nonnull
	public LocalDate getPeriodeVon() {
		return periodeVon;
	}

	public void setPeriodeVon(@Nonnull LocalDate periodeVon) {
		this.periodeVon = periodeVon;
	}

	@Nonnull
	public LocalDate getPeriodeBis() {
		return periodeBis;
	}

	public void setPeriodeBis(@Nonnull LocalDate periodeBis) {
		this.periodeBis = periodeBis;
	}

	@Nonnull
	public List<ModulDTO> getModule() {
		return module;
	}

	public void setModule(@Nonnull List<ModulDTO> module) {
		this.module = module;
	}
}
