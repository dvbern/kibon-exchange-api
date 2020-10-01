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
	private List<TarifDTO> tarifePaedagogisch;

	@NotNull
	@Valid
	@Nonnull
	private List<TarifDTO> tarifeNichtPaedagogisch;

	@Schema(description = "Gibt an, ob die finanzielle Situation bereits von der Gemeinde akzeptiert wurde. Falls "
		+ "nicht, wird jeweils der Maximaltarif ausgegeben.")
	@NotNull
	@Nonnull
	private Boolean finanzielleSituationAkzeptiert;

	public TagesschuleTarifeDTO() {
		this.refnr = "";
		this.tarifePaedagogisch = new ArrayList<>();
		this.tarifeNichtPaedagogisch = new ArrayList<>();
		this.finanzielleSituationAkzeptiert = false;
	}

	public TagesschuleTarifeDTO(
		@Nonnull String refnr,
		@Nonnull List<TarifDTO> tarifePaedagogisch,
		@Nonnull List<TarifDTO> tarifeNichtPaedagogisch,
		@Nonnull Boolean finanzielleSituationAkzeptiert) {
		this.refnr = refnr;
		this.tarifePaedagogisch = tarifePaedagogisch;
		this.tarifeNichtPaedagogisch = tarifeNichtPaedagogisch;
		this.finanzielleSituationAkzeptiert = finanzielleSituationAkzeptiert;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", TagesschuleTarifeDTO.class.getSimpleName() + '[', "]")
			.add("refnr='" + refnr + '\'')
			.add("tarifePaedagogisch=" + tarifePaedagogisch)
			.add("tarifeNichtPaedagogisch=" + tarifeNichtPaedagogisch)
			.add("finanzielleSituationAkzeptiert=" + finanzielleSituationAkzeptiert)
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
			getTarifePaedagogisch().equals(that.getTarifePaedagogisch()) &&
			getTarifeNichtPaedagogisch().equals(that.getTarifeNichtPaedagogisch()) &&
			getFinanzielleSituationAkzeptiert().equals(that.getFinanzielleSituationAkzeptiert());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getRefnr(),
			getTarifePaedagogisch(),
			getTarifeNichtPaedagogisch(),
			getFinanzielleSituationAkzeptiert());
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public List<TarifDTO> getTarifePaedagogisch() {
		return tarifePaedagogisch;
	}

	public void setTarifePaedagogisch(@Nonnull List<TarifDTO> tarifePaedagogisch) {
		this.tarifePaedagogisch = tarifePaedagogisch;
	}

	@Nonnull
	public List<TarifDTO> getTarifeNichtPaedagogisch() {
		return tarifeNichtPaedagogisch;
	}

	public void setTarifeNichtPaedagogisch(@Nonnull List<TarifDTO> tarifeNichtPaedagogisch) {
		this.tarifeNichtPaedagogisch = tarifeNichtPaedagogisch;
	}

	@Nonnull
	public Boolean getFinanzielleSituationAkzeptiert() {
		return finanzielleSituationAkzeptiert;
	}

	public void setFinanzielleSituationAkzeptiert(@Nonnull Boolean finanzielleSituationAkzeptiert) {
		this.finanzielleSituationAkzeptiert = finanzielleSituationAkzeptiert;
	}
}
