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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.dvbern.kibon.exchange.api.common.tagesschule.tarife.TagesschuleTarifeDTO;
import ch.dvbern.kibon.exchange.api.common.tagesschule.tarife.TarifDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Entspricht einer Anmeldung bei einer Tagesschule")
public class TagesschuleAnmeldungDTO implements Serializable {

	private static final long serialVersionUID = 5301362613765275883L;

	@Schema(description = "Strikt monoton steigende ID\n\nKann für Filterung mit dem `after_id` Parameter verwendet "
		+ "werden.")
	@NotNull
	@Nonnull
	private Long id = -1L;

	@Schema(description = "Die ID der Institution, für welche die Anmeldung erstellt wurde.")
	@Size(min = 1)
	@NotNull
	@Nonnull
	private String institutionId = "";

	@Schema(description = "Eindeutige kiBon Referenz Nummmer\n\nSetzt sich zusammen aus JAHR.FALL.GEMEINDE.KIND"
		+ ".BETREUUNG")
	@Size(min = 1)
	@NotNull
	@Nonnull
	private String refnr = "";

	@Schema(description = "Die Version der Anmeldung. Eine höhere Version ersetzt eine niedrigere Version mit "
		+ "identischer \"refnr\"")
	@NotNull
	@Min(0)
	@Nonnull
	private Integer version = 0;

	@Schema(description = "Status der Anmeldung.")
	@NotNull
	@Nonnull
	private TagesschuleAnmeldungStatus status;

	@Schema(description = "Zeitpunkt, an welchem die Anmeldung freigegeben wurde.")
	@NotNull
	@Nonnull
	private LocalDateTime eventTimestamp = LocalDateTime.MIN;

	@Schema(description = "Start des Schuljahr Periode, e.g. 2020-08-01")
	@NotNull
	@Nonnull
	private LocalDate periodeVon = LocalDate.MIN;

	@Schema(description = "Ende der Schuljahr Periode, e.g. 2021-07-31")
	@NotNull
	@Nonnull
	private LocalDate periodeBis = LocalDate.MAX;

	@Schema(description = "Gewünschter Beginn der Betreuung in der Tagesschule.")
	@NotNull
	@Nonnull
	private LocalDate eintrittsdatum = LocalDate.MIN;

	@Schema(description = "Die Klasse, die das Kind besuchen wird")
	@Size(min = 1)
	@Nullable
	private String planKlasse = null;

	@Schema(description = "Von der Antrag-stellenden Person definierte Erlaubniss, ob das Kind alleine nach Hause "
		+ "gehen darf, oder ob es immer angeholt wird\n\nNull, wenn keine explizite Ausgwahl getroffen wurde")
	@Nullable
	private AbholungTagesschule abholung = null;

	@Schema(description = "`true`, Falls das Kind im 2. Semester andere Betreuungszeiten benötigt, weil sich der "
		+ "Stundenplan ändert.")
	@NotNull
	@Nonnull
	private Boolean abweichungZweitesSemester = false;

	@Schema(description = "Freitext. Enthält z.B. Änderungen der Betreuungszeiten oder allfällige Fragen an die "
		+ "Tagesschule")
	@Nullable
	private String bemerkung = null;

	@Schema(description = "Details zum Kind, welches die Tagesschule besuchen soll")
	@Valid
	@NotNull
	@Nonnull
	private TagesschuleKindDTO kind = new TagesschuleKindDTO();

	@Schema(description = "Details zur gesuchstellenden Person")
	@Valid
	@NotNull
	@Nonnull
	private TagesschuleGesuchstellerDTO gesuchsteller = new TagesschuleGesuchstellerDTO();

	@Schema(description = "Details zur 2. gesuchstellenden Person")
	@Valid
	@Nullable
	private TagesschuleGesuchstellerDTO gesuchsteller2;

	@Schema(description = "Die gewünschten Betreuungs-Module.\n\n"
		+ "Falls die Anmeldung zurückgezogen wurde, kann das Array leer sein.")
	@NotNull
	@Nonnull
	private List<ModulAuswahlDTO> module = new ArrayList<>();

	@Schema(description = "Tarife der Tagesschul-Betreuung.\n\n"
		+ "Noch nicht bestätigte TagesschulAnmeldungen enthalten noch keine Tarife.\n\n"
		+ "Die Tarife sind abhängig von der finanziellen Situation der Familie und müssen durch die Gemeinde verfügt "
		+ "werden.")
	@Nullable
	private TagesschuleTarifeDTO tarife = null;

	@Schema(description = "In einzelfällen kann eine Anmledung widerrufen werden. `true`, falls eine Anmeldung nicht "
		+ "mehr gilt.\n"
		+ "Dies bedingt, dass es zuvor eine Anmeldung gegeben hat (mit identischer `refnr` und `institutionId`, "
		+ "aber niedriger `version`.")
	private boolean anmeldungZurueckgezogen = false;

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", TagesschuleAnmeldungDTO.class.getSimpleName() + '[', "]")
			.add("id='" + id + '\'')
			.add("institutionId='" + institutionId + '\'')
			.add("refnr='" + refnr + '\'')
			.add("version=" + version)
			.add("status=" + status)
			.add("periodeVon=" + periodeVon)
			.add("periodeBis=" + periodeBis)
			.add("kind=" + kind)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TagesschuleAnmeldungDTO)) {
			return false;
		}

		TagesschuleAnmeldungDTO that = (TagesschuleAnmeldungDTO) o;

		return getId().equals(that.getId()) &&
			getInstitutionId().equals(that.getInstitutionId()) &&
			getRefnr().equals(that.getRefnr()) &&
			getVersion().equals(that.getVersion()) &&
			getStatus() == that.getStatus() &&
			getEventTimestamp().equals(that.getEventTimestamp()) &&
			getPeriodeVon().equals(that.getPeriodeVon()) &&
			getPeriodeBis().equals(that.getPeriodeBis()) &&
			getEintrittsdatum().equals(that.getEintrittsdatum()) &&
			Objects.equals(getPlanKlasse(), that.getPlanKlasse()) &&
			getAbholung() == that.getAbholung() &&
			getAbweichungZweitesSemester().equals(that.getAbweichungZweitesSemester()) &&
			Objects.equals(getBemerkung(), that.getBemerkung()) &&
			getKind().equals(that.getKind()) &&
			getGesuchsteller().equals(that.getGesuchsteller()) &&
			Objects.equals(getGesuchsteller2(), that.getGesuchsteller2()) &&
			getModule().equals(that.getModule()) &&
			isAnmeldungZurueckgezogen() == that.isAnmeldungZurueckgezogen();
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getId(),
			getInstitutionId(),
			getRefnr(),
			getVersion(),
			getStatus(),
			getEventTimestamp(),
			getPeriodeVon(),
			getPeriodeBis(),
			getEintrittsdatum(),
			getPlanKlasse(),
			getAbholung(),
			getAbweichungZweitesSemester(),
			getBemerkung(),
			getKind(),
			getGesuchsteller(),
			getGesuchsteller2(),
			getModule(),
			isAnmeldungZurueckgezogen());
	}

	@Nonnull
	public Long getId() {
		return id;
	}

	public void setId(@Nonnull Long id) {
		this.id = id;
	}

	@Nonnull
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public Integer getVersion() {
		return version;
	}

	public void setVersion(@Nonnull Integer version) {
		this.version = version;
	}

	@Nonnull
	public TagesschuleAnmeldungStatus getStatus() {
		return status;
	}

	public void setStatus(@Nonnull TagesschuleAnmeldungStatus status) {
		this.status = status;
	}

	@Nonnull
	public LocalDateTime getEventTimestamp() {
		return eventTimestamp;
	}

	public void setEventTimestamp(@Nonnull LocalDateTime eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
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
	public LocalDate getEintrittsdatum() {
		return eintrittsdatum;
	}

	public void setEintrittsdatum(@Nonnull LocalDate eintrittsdatum) {
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

	@Nonnull
	public Boolean getAbweichungZweitesSemester() {
		return abweichungZweitesSemester;
	}

	public void setAbweichungZweitesSemester(@Nonnull Boolean abweichungZweitesSemester) {
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
	public TagesschuleKindDTO getKind() {
		return kind;
	}

	public void setKind(@Nonnull TagesschuleKindDTO kind) {
		this.kind = kind;
	}

	@Nonnull
	public List<ModulAuswahlDTO> getModule() {
		return module;
	}

	public void setModule(@Nonnull List<ModulAuswahlDTO> module) {
		this.module = module;
	}

	@Nullable
	public TagesschuleTarifeDTO getTarife() {
		return tarife;
	}

	public void setTarife(@Nullable TagesschuleTarifeDTO tarife) {
		this.tarife = tarife;
	}

	public boolean isAnmeldungZurueckgezogen() {
		return anmeldungZurueckgezogen;
	}

	public void setAnmeldungZurueckgezogen(boolean anmeldungZurueckgezogen) {
		this.anmeldungZurueckgezogen = anmeldungZurueckgezogen;
	}

	@Nonnull
	public TagesschuleGesuchstellerDTO getGesuchsteller() {
		return gesuchsteller;
	}

	public void setGesuchsteller(@Nonnull TagesschuleGesuchstellerDTO gesuchsteller) {
		this.gesuchsteller = gesuchsteller;
	}

	@Nullable
	public TagesschuleGesuchstellerDTO getGesuchsteller2() {
		return gesuchsteller2;
	}

	public void setGesuchsteller2(@Nullable TagesschuleGesuchstellerDTO gesuchsteller2) {
		this.gesuchsteller2 = gesuchsteller2;
	}
}
