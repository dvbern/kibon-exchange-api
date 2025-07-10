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

public class TagesschuleBestaetigungDTO implements Serializable {

	private static final long serialVersionUID = -275417015811224616L;

	@Schema(description = "Eindeutige kiBon Referenz Nummmer\n\nSetzt sich zusammen aus JAHR.FALL.GEMEINDE.KIND"
		+ ".BETREUUNG")
	@Size(min = 1)
	@NotNull
	@Nonnull
	private String refnr;

	@Schema(description = "Beginn der Betreuung in der Tagesschule.")
	@Nullable
	private LocalDate eintrittsdatum;

	@Schema(description = "Die Klasse, die das Kind besuchen wird.")
	@Size(min = 1)
	@Nullable
	private String planKlasse;

	@Schema(description = "Von der Antrag-stellenden Person definierte Erlaubniss, ob das Kind alleine nach Hause "
		+ "gehen darf, oder ob es immer angeholt wird\n\nNull, wenn keine explizite Ausgwahl getroffen wurde.")
	@Nullable
	private AbholungTagesschule abholung;

	@Schema(description = "`true`, Falls das Kind im 2. Semester andere Betreuungszeiten benötigt, weil sich der "
		+ "Stundenplan ändert.")
	@Nullable
	private Boolean abweichungZweitesSemester;

	@Schema(description = "Freitext. Enthält z.B. Änderungen der Betreuungszeiten oder allfällige Fragen.")
	@Nullable
	private String bemerkung;

	@Schema(description = "Die von der Tagesschule bestätigen/akzeptierten Module.")
	@NotNull
	@Valid
	@Size(min = 1)
	@Nonnull
	private List<ModulAuswahlDTO> module;

	public TagesschuleBestaetigungDTO() {
		this("", new ArrayList<>());
	}

	public TagesschuleBestaetigungDTO(
		@Nonnull String refnr,
		@Nonnull List<ModulAuswahlDTO> module) {
		this(refnr, null, null, null, null, null, module);
	}

	public TagesschuleBestaetigungDTO(
		@Nonnull String refnr,
		@Nullable LocalDate eintrittsdatum,
		@Nullable String planKlasse,
		@Nullable AbholungTagesschule abholung,
		@Nullable Boolean abweichungZweitesSemester,
		@Nullable String bemerkung,
		@Nonnull List<ModulAuswahlDTO> module) {
		this.refnr = refnr;
		this.eintrittsdatum = eintrittsdatum;
		this.planKlasse = planKlasse;
		this.abholung = abholung;
		this.abweichungZweitesSemester = abweichungZweitesSemester;
		this.bemerkung = bemerkung;
		this.module = module;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", TagesschuleBestaetigungDTO.class.getSimpleName() + '[', "]")
			.add("refnr='" + refnr + '\'')
			.add("eintrittsdatum=" + eintrittsdatum)
			.add("planKlasse='" + planKlasse + '\'')
			.add("abholung=" + abholung)
			.add("abweichungZweitesSemester=" + abweichungZweitesSemester)
			.add("bemerkung='" + bemerkung + '\'')
			.add("module=" + module)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TagesschuleBestaetigungDTO)) {
			return false;
		}

		TagesschuleBestaetigungDTO that = (TagesschuleBestaetigungDTO) o;

		return getRefnr().equals(that.getRefnr()) &&
			Objects.equals(getEintrittsdatum(), that.getEintrittsdatum()) &&
			Objects.equals(getPlanKlasse(), that.getPlanKlasse()) &&
			getAbholung() == that.getAbholung() &&
			Objects.equals(getAbweichungZweitesSemester(), that.getAbweichungZweitesSemester()) &&
			Objects.equals(getBemerkung(), that.getBemerkung()) &&
			getModule().equals(that.getModule());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getRefnr(),
			getEintrittsdatum(),
			getPlanKlasse(),
			getAbholung(),
			getAbweichungZweitesSemester(),
			getBemerkung(),
			getModule());
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nullable
	public LocalDate getEintrittsdatum() {
		return eintrittsdatum;
	}

	public void setEintrittsdatum(@Nullable LocalDate eintrittsdatum) {
		this.eintrittsdatum = eintrittsdatum;
	}

	@Nullable
	public String getPlanKlasse() {
		return planKlasse;
	}

	public void setPlanKlasse(@Nullable String planKlasse) {
		this.planKlasse = planKlasse;
	}

	@Nullable
	public AbholungTagesschule getAbholung() {
		return abholung;
	}

	public void setAbholung(@Nullable AbholungTagesschule abholung) {
		this.abholung = abholung;
	}

	@Nullable
	public Boolean getAbweichungZweitesSemester() {
		return abweichungZweitesSemester;
	}

	public void setAbweichungZweitesSemester(@Nullable Boolean abweichungZweitesSemester) {
		this.abweichungZweitesSemester = abweichungZweitesSemester;
	}

	@Nullable
	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(@Nullable String bemerkung) {
		this.bemerkung = bemerkung;
	}

	@Nonnull
	public List<ModulAuswahlDTO> getModule() {
		return module;
	}

	public void setModule(@Nonnull List<ModulAuswahlDTO> module) {
		this.module = module;
	}
}
