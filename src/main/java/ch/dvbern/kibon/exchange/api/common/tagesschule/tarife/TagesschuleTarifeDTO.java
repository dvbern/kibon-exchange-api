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

package ch.dvbern.kibon.exchange.api.common.tagesschule.tarife;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class TagesschuleTarifeDTO implements Serializable {

	private static final long serialVersionUID = -4642606338279722793L;

	@Schema(description = "Eindeutige kiBon Referenz Nummmer\n\nSetzt sich zusammen aus JAHR.FALL.GEMEINDE.KIND"
		+ ".BETREUUNG")
	@Size(min = 1)
	@NotNull
	@Nonnull
	private String refnr;

	@NotNull
	@Valid
	@Nonnull
	private List<TarifZeitabschnittDTO> tarifZeitabschnitte;

	@Schema(description = "Gibt an, ob die Tarife definitiv von der Gemeinde akzeptiert wurde oder nicht.")
	@NotNull
	@Nonnull
	private Boolean tarifeDefinitivAkzeptiert;

	public TagesschuleTarifeDTO() {
		this.refnr = "";
		this.tarifZeitabschnitte = new ArrayList<>();
		this.tarifeDefinitivAkzeptiert = false;
	}

	public TagesschuleTarifeDTO(
		@Nonnull String refnr,
		@Nonnull List<TarifZeitabschnittDTO> tarifZeitabschnitte,
		@Nonnull Boolean tarifeDefinitivAkzeptiert) {
		this.refnr = refnr;
		this.tarifZeitabschnitte = tarifZeitabschnitte;
		this.tarifeDefinitivAkzeptiert = tarifeDefinitivAkzeptiert;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", TagesschuleTarifeDTO.class.getSimpleName() + '[', "]")
			.add("refnr='" + refnr + '\'')
			.add("tarifZeitabschnitte=" + tarifZeitabschnitte)
			.add("tarifeDefinitivAkzeptiert=" + tarifeDefinitivAkzeptiert)
			.toString();
	}

	@Override
	public boolean equals(@Nonnull Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TagesschuleTarifeDTO)) {
			return false;
		}

		TagesschuleTarifeDTO that = (TagesschuleTarifeDTO) o;

		return getRefnr().equals(that.getRefnr()) &&
			getTarifZeitabschnitte().equals(that.getTarifZeitabschnitte()) &&
			getTarifeDefinitivAkzeptiert().equals(that.getTarifeDefinitivAkzeptiert());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getRefnr(),
			getTarifZeitabschnitte(),
			getTarifeDefinitivAkzeptiert());
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public List<TarifZeitabschnittDTO> getTarifZeitabschnitte() {
		return tarifZeitabschnitte;
	}

	public void setTarifZeitabschnitte(@Nonnull List<TarifZeitabschnittDTO> tarifZeitabschnitte) {
		this.tarifZeitabschnitte = tarifZeitabschnitte;
	}

	@Nonnull
	public Boolean getTarifeDefinitivAkzeptiert() {
		return tarifeDefinitivAkzeptiert;
	}

	public void setTarifeDefinitivAkzeptiert(@Nonnull Boolean tarifeDefinitivAkzeptiert) {
		this.tarifeDefinitivAkzeptiert = tarifeDefinitivAkzeptiert;
	}
}
