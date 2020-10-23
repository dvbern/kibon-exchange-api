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

package ch.dvbern.kibon.exchange.api.common.platzbestaetigung;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.Zeiteinheit;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Beschreibt die monatlichen Betreuungsangaben\n\n."
	+ "Falls sich eine der Angaben innerhalb eines Monats ändern, soll dafür ein neuer Zeitabschnitt übermittelt "
	+ "werden.")
public class BetreuungZeitabschnittDTO implements Serializable {

	private static final long serialVersionUID = 5776618318243644061L;

	@Schema(description = "Die monatlichen Betreuungskosten (ohne Verpflegungskosten)\n\n"
		+ "Auch bei untermonatlichen Eintritten müssen die monatlichen Kosten erfasst werden.")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal betreuungskosten;

	@Schema(description = "Das monatliche Pensum in Prozent oder Tage resp. Stunden bei Tagesfamilien.\n\n"
		+ "Beachten Sie dabei die Bestimmungen zur Berechnung der Betreuungseinheit in Art. 17 bzw. 18 "
		+ "BGSDV. Dort ist festgelegt, wie das vergünstigte Betreuungspensum in Prozent je nach Spanne der nutzbaren "
		+ "Kinderbetreuung berechnet wird.\n\n"
		+ "Buchen die Eltern Betreuungsmodule, muss eine allfällige Kindergartenzeit in Abzug gebracht werden. "
		+ "(Beispiel: Eine Familie hat in einer Kita das Betreuungsmodul von 7:00-12:00 gebucht (5h). Das Kind besucht"
		+ " aber während 3.5 h den Kindergarten. Dies ergibt eine Betreuungsdauer von 5h-3.5h = 1.5h. Gem. Art. 17. "
		+ "der BGSDV entsprechen die 1.5h einem Betreuungspensum von 5%).\n\n"
		+ "Die Angabe in Stunden erfolgt Dezimal, d.h 1.5 entspricht 1 Stunde 30 Minuten.\n\n"
		+ "Auch bei untermonatlichen Eintritten müssen die Stunden für einen ganzen Monat erfasst werden.")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal betreuungspensum;

	@Nonnull
	private @NotNull LocalDate von;

	@Nonnull
	private @NotNull LocalDate bis;

	@Schema(description = "Beschreibt, ob das Pensum in Prozent, Tagen oder Stunden gemeldet wird.")
	@Nonnull
	private @NotNull Zeiteinheit pensumUnit;

	@Schema(description = "Die Anzahl Mittagessen/Abendessen, die für diese Betreuung tatsächlich verrechnet wird.\n\n"
		+ "Auch bei untermonatlichen Eintritten muss die Anzahl Mittagessen für einen ganzen Monat erfasst werden.")
	@Nonnull
	private @NotNull @Min(0) BigDecimal anzahlMonatlicheHauptmahlzeiten;

	@Schema(description = "Die Nebenmahlzeiten, die für diese Betreuung tatsächlich verrechnet werden.\n\n"
		+ "Dies betrifft nur Institutioen, welche die Kosten für die Nebenmahlzeiten, zusätzlich zu der "
		+ "Mittagessenpauschale, vertraglich festhalten und diese auch in Rechnung stellen.\n\n"
		+ "Auch bei untermonatlichen Eintritten muss die Anzahl Nebenmahlzeiten für einen ganzen Monat erfasst "
		+ "werden.")
	@Nonnull
	private @NotNull @Min(0) BigDecimal anzahlMonatlicheNebenmahlzeiten;

	@Schema(description = "Der Tarif für ein Mittagessen/Abendessen.\n\n"
		+ "Werden alle Mahlzeiten in einer Pauschale verrechnen, soll die Pauschale gesetzt werden.\n\n"
		+ "Werden keine Verpflegungskosten verrechnet, soll `0` übergeben werden.")
	@Nullable
	private BigDecimal tarifProHauptmahlzeiten;

	@Schema(description = "Der Tarif für Nebenmahlzeiten, welche explizit als solche in Rechnung gestellt werden.\n\n"
		+ "Werden alle Mahlzeiten in einer Pauschale verrechnen, soll die Pauschale gesetzt werden.\n\n"
		+ "Werden keine Verpflegungskosten verrechnet, soll `0` übergeben werden.")
	@Nullable
	private BigDecimal tarifProNebenmahlzeiten;

	public BetreuungZeitabschnittDTO() {
		this.betreuungskosten = BigDecimal.ZERO;
		this.betreuungspensum = BigDecimal.ZERO;
		this.von = LocalDate.MIN;
		this.bis = LocalDate.MAX;
		this.pensumUnit = Zeiteinheit.DAYS;
		this.anzahlMonatlicheHauptmahlzeiten = BigDecimal.ZERO;
		this.anzahlMonatlicheNebenmahlzeiten = BigDecimal.ZERO;
		this.tarifProHauptmahlzeiten = null;
		this.tarifProNebenmahlzeiten = null;
	}

	public BetreuungZeitabschnittDTO(
		@Nonnull BigDecimal betreuungskosten,
		@Nonnull BigDecimal betreuungspensum,
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nonnull Zeiteinheit pensumUnit,
		@Nonnull BigDecimal anzahlMonatlicheHauptmahlzeiten,
		@Nonnull BigDecimal anzahlMonatlicheNebenmahlzeiten,
		@Nullable BigDecimal tarifProHauptmahlzeiten,
		@Nullable BigDecimal tarifProNebenmahlzeiten) {
		this.betreuungskosten = betreuungskosten;
		this.betreuungspensum = betreuungspensum;
		this.von = von;
		this.bis = bis;
		this.pensumUnit = pensumUnit;
		this.anzahlMonatlicheHauptmahlzeiten = anzahlMonatlicheHauptmahlzeiten;
		this.anzahlMonatlicheNebenmahlzeiten = anzahlMonatlicheNebenmahlzeiten;
		this.tarifProHauptmahlzeiten = tarifProHauptmahlzeiten;
		this.tarifProNebenmahlzeiten = tarifProNebenmahlzeiten;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		BetreuungZeitabschnittDTO that = (BetreuungZeitabschnittDTO) o;

		return getVon().equals(that.getVon()) &&
			getBis().equals(that.getBis()) &&
			getPensumUnit() == that.getPensumUnit() &&
			getBetreuungskosten().compareTo(that.getBetreuungskosten()) == 0 &&
			getBetreuungspensum().compareTo(that.getBetreuungspensum()) == 0 &&
			getAnzahlMonatlicheHauptmahlzeiten().equals(that.getAnzahlMonatlicheHauptmahlzeiten()) &&
			getAnzahlMonatlicheNebenmahlzeiten().equals(that.getAnzahlMonatlicheNebenmahlzeiten());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getVon(),
			getBis(),
			getPensumUnit(),
			getBetreuungskosten(),
			getBetreuungspensum(),
			getAnzahlMonatlicheHauptmahlzeiten(),
			getAnzahlMonatlicheNebenmahlzeiten());
	}

	@Nonnull
	public BigDecimal getBetreuungskosten() {
		return betreuungskosten;
	}

	public void setBetreuungskosten(@Nonnull BigDecimal betreuungskosten) {
		this.betreuungskosten = betreuungskosten;
	}

	@Nonnull
	public BigDecimal getBetreuungspensum() {
		return betreuungspensum;
	}

	public void setBetreuungspensum(@Nonnull BigDecimal betreuungspensum) {
		this.betreuungspensum = betreuungspensum;
	}

	@Nonnull
	public LocalDate getVon() {
		return von;
	}

	public void setVon(@Nonnull LocalDate von) {
		this.von = von;
	}

	@Nonnull
	public LocalDate getBis() {
		return bis;
	}

	public void setBis(@Nonnull LocalDate bis) {
		this.bis = bis;
	}

	@Nonnull
	public Zeiteinheit getPensumUnit() {
		return pensumUnit;
	}

	public void setPensumUnit(@Nonnull Zeiteinheit pensumUnit) {
		this.pensumUnit = pensumUnit;
	}

	@Nonnull
	public BigDecimal getAnzahlMonatlicheHauptmahlzeiten() {
		return anzahlMonatlicheHauptmahlzeiten;
	}

	public void setAnzahlMonatlicheHauptmahlzeiten(@Nonnull BigDecimal anzahlMonatlicheHauptmahlzeiten) {
		this.anzahlMonatlicheHauptmahlzeiten = anzahlMonatlicheHauptmahlzeiten;
	}

	@Nonnull
	public BigDecimal getAnzahlMonatlicheNebenmahlzeiten() {
		return anzahlMonatlicheNebenmahlzeiten;
	}

	public void setAnzahlMonatlicheNebenmahlzeiten(@Nonnull BigDecimal anzahlMonatlicheNebenmahlzeiten) {
		this.anzahlMonatlicheNebenmahlzeiten = anzahlMonatlicheNebenmahlzeiten;
	}

	@Nullable
	public BigDecimal getTarifProHauptmahlzeiten() {
		return tarifProHauptmahlzeiten;
	}

	public void setTarifProHauptmahlzeiten(@Nullable BigDecimal tarifProHauptmahlzeiten) {
		this.tarifProHauptmahlzeiten = tarifProHauptmahlzeiten;
	}

	@Nullable
	public BigDecimal getTarifProNebenmahlzeiten() {
		return tarifProNebenmahlzeiten;
	}

	public void setTarifProNebenmahlzeiten(@Nullable BigDecimal tarifProNebenmahlzeiten) {
		this.tarifProNebenmahlzeiten = tarifProNebenmahlzeiten;
	}
}
