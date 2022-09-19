/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.dvbern.kibon.exchange.api.common.dashboard.verfuegung;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.Zeiteinheit;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static ch.dvbern.kibon.exchange.api.common.util.ComparatorUtil.comparesEqual;

public class ZeitabschnittDTO implements Serializable {

	private static final long serialVersionUID = -5532221922594405154L;

	@Nonnull
	private @NotNull LocalDate von;

	@Nonnull
	private @NotNull LocalDate bis;

	@Schema(description = "Bezeichnet das mit der Betreuungsinstitution vereinbarte Betreuungspensum in %.")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal effektiveBetreuungPct;

	@Schema(description = "Bezeichnet das anspruchsberechtigte Betreuungspensum in %, d.h. das Betreuungspensum, das "
		+ "durch die Gemeinde maximal durch einen Betreuungsgutschein vergünstigt würde.")
	@Nonnull
	private @NotNull @Min(0) @Max(100) Integer anspruchPct;

	@Schema(description = "Bezeichnet das anspruchsberechtigte Betreuungspensum in %, d.h. das Betreuungspensum, das "
		+ "durch die Gemeinde maximal durch einen Betreuungsgutschein vergünstigt würde.\n\n"
		+ "`verguenstigtPct = min(effektiveBetreuungPct, anspruchPct)`")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal verguenstigtPct;

	@Schema(description = "Bezeichnet die Betreuungskosten in CHF der Institution für das vergünstigte Pensum.\n\n"
		+ "Kosten für Mahlzeiten und allfällige Zusatzleistungen wie Windeln etc. sind in diesem Betrag nicht "
		+ "enthalten.")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal vollkosten;

	@Schema(description = "Der berechnete Gutschein in CHF bezeichnet die Vergünstigung, welche aufgrund des "
		+ "vergünstigten Pensums und des für die Berechnung des Gutscheins massgebenden Einkommens resultiert.\n\n"
		+ "Falls der berechnete Gutschein höher ist als die Betreuungskosten, wird der berechnete Gutschein gekürzt, "
		+ "so dass der Gutschein die betreuungskosten nicht übersteigt.")
	@Nullable
	private @DecimalMin("0") BigDecimal betreuungsgutschein;

	@Schema(description =
		"Der berechnete Gutschein in CHF fuer der Gemeinde,  bezeichnet die Vergünstigung, welche aufgrund des "
			+ "vergünstigten Pensums, die Gemeinde extra Gutschein Regeln und des für die Berechnung des Gutscheins "
			+ "massgebenden Einkommens resultiert.")
	@Nullable
	private @DecimalMin("0") BigDecimal betreuungsgutscheinGemeinde;

	@Schema(description = "Der berechnete Gutschein in CHF bezeichnet die Vergünstigung, welche aufgrund des "
		+ "vergünstigten Pensums und des für die Berechnung des Gutscheins massgebenden Einkommens resultiert.\n\n"
		+ "Falls der berechnete Gutschein höher ist als die Betreuungskosten, wird der berechnete Gutschein gekürzt, "
		+ "so dass der Gutschein die betreuungskosten nicht übersteigt.")
	@Nullable
	private @DecimalMin("0") BigDecimal betreuungsgutscheinKanton;

	@Schema(description = "Die Eltern müssen einen minimalen Elternbeitrag leisten. Falls dies noch nicht der Fall "
		+ "ist, weil die Kosten vollständig oder fast vollständig durch den Betreuungsgutschein gedeckt werden, muss "
		+ "die Kita oder Tagesfamilienorganisation den Eltern den (fehlenden) minimalen Elternbeitrag in Rechnung "
		+ "stellen.\n\n"
		+ "Der minimale Elternbeitrag beträgt 7 Franken pro Betreuungstag (20% Pensum pro Woche) in einer Kita und 70 "
		+ "Rappen pro Betreuungsstunde bei Tagesfamilien.")
	@Nullable
	private @DecimalMin("0") BigDecimal minimalerElternbeitrag;

	@Schema(description = "Bezeichnet den Betrag in CHF, der an die Institution überwiesen wird. Dieser entspricht "
		+ "dem Betreuungsgutschein abzüglich eines allfälligen minimalen Elternbeitrags (den die Kita bzw. die "
		+ "Tagesfamilienorganisation  den Eltern in Rechnung stellen würde).")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal verguenstigung;

	@Schema(description = "Die Anzahl der Zeiteinheiten, die innerhalb der Periode dieses Zeitabschnitts belegt werden"
		+ " dürfen.")
	@Nullable
	private @DecimalMin("0") BigDecimal verfuegteAnzahlZeiteinheiten;

	@Schema(description = "Die Anzahl der Zeitenheiten, innerhalb der Periode dieses Zeitabschnitts für welche ein "
		+ "Anspruch besteht.")
	@Nullable
	private @DecimalMin("0") BigDecimal anspruchsberechtigteAnzahlZeiteinheiten;

	@Schema(description = "Je nach BetreuungsAngebot gelten unterschiedliche Zeitenheiten. Grundsätzlich wird die "
		+ "Anzahl Betreuungs-Tage nach ASIV innerhalb der Periode verfügt. Bei TAGESFAMILIEN wird jedoch ein Gutschein"
		+ " für eine bestimmte Anzahl Betreuungsstunden verfügt.")
	@Nullable
	private Zeiteinheit zeiteinheit;

	@Schema(description = "Massgebendes Einkommen, mit abzug Familiengrösse, die wuerde als basis fuer die Berechnung "
		+ "von dieser Zeitabschnitt verwendet.")
	@Nonnull
	private @NotNull BigDecimal massgebendesEinkommen;

	private boolean besondereBeduerfnisse;

	public ZeitabschnittDTO() {
		this.von = LocalDate.MIN;
		this.bis = LocalDate.MIN;
		this.effektiveBetreuungPct = BigDecimal.ZERO;
		this.anspruchPct = -1;
		this.verguenstigtPct = BigDecimal.ZERO;
		this.vollkosten = BigDecimal.ZERO;
		this.verguenstigung = BigDecimal.ZERO;
		this.betreuungsgutschein = BigDecimal.ZERO;
		this.betreuungsgutscheinGemeinde = BigDecimal.ZERO;
		this.betreuungsgutscheinKanton = BigDecimal.ZERO;
		this.minimalerElternbeitrag = BigDecimal.ZERO;
		this.verfuegteAnzahlZeiteinheiten = BigDecimal.ZERO;
		this.anspruchsberechtigteAnzahlZeiteinheiten = BigDecimal.ZERO;
		this.zeiteinheit = Zeiteinheit.PERCENTAGE;
		this.massgebendesEinkommen = BigDecimal.ZERO;
		this.besondereBeduerfnisse = false;
	}

	public ZeitabschnittDTO(
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nonnull BigDecimal effektiveBetreuungPct,
		@Nonnull Integer anspruchPct,
		@Nonnull BigDecimal verguenstigtPct,
		@Nonnull BigDecimal vollkosten,
		@Nullable BigDecimal betreuungsgutschein,
		@Nullable BigDecimal betreuungsgutscheinGemeinde,
		@Nullable BigDecimal betreuungsgutscheinKanton,
		@Nullable BigDecimal minimalerElternbeitrag,
		@Nonnull BigDecimal verguenstigung,
		@Nullable BigDecimal verfuegteAnzahlZeiteinheiten,
		@Nullable BigDecimal anspruchsberechtigteAnzahlZeiteinheiten,
		@Nullable Zeiteinheit zeiteinheit,
		@Nonnull BigDecimal massgebendesEinkommen,
		boolean besondereBeduerfnisse) {
		this.von = von;
		this.bis = bis;
		this.effektiveBetreuungPct = effektiveBetreuungPct;
		this.anspruchPct = anspruchPct;
		this.verguenstigtPct = verguenstigtPct;
		this.vollkosten = vollkosten;
		this.betreuungsgutschein = betreuungsgutschein;
		this.betreuungsgutscheinGemeinde = betreuungsgutscheinGemeinde;
		this.betreuungsgutscheinKanton = betreuungsgutscheinKanton;
		this.minimalerElternbeitrag = minimalerElternbeitrag;
		this.verguenstigung = verguenstigung;
		this.verfuegteAnzahlZeiteinheiten = verfuegteAnzahlZeiteinheiten;
		this.anspruchsberechtigteAnzahlZeiteinheiten = anspruchsberechtigteAnzahlZeiteinheiten;
		this.zeiteinheit = zeiteinheit;
		this.massgebendesEinkommen = massgebendesEinkommen;
		this.besondereBeduerfnisse = besondereBeduerfnisse;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		ZeitabschnittDTO that = (ZeitabschnittDTO) o;

		return getVon().equals(that.getVon())
			&& getBis().equals(that.getBis())
			&& comparesEqual(getEffektiveBetreuungPct(), that.getEffektiveBetreuungPct())
			&& getAnspruchPct().equals(that.getAnspruchPct())
			&& comparesEqual(getVerguenstigung(), that.getVerguenstigung())
			&& comparesEqual(getVollkosten(), that.getVollkosten())
			&& comparesEqual(getBetreuungsgutschein(), that.getBetreuungsgutschein())
			&& comparesEqual(getBetreuungsgutscheinGemeinde(), that.getBetreuungsgutscheinGemeinde())
			&& comparesEqual(getBetreuungsgutscheinKanton(), that.getBetreuungsgutscheinKanton())
			&& comparesEqual(getMinimalerElternbeitrag(), that.getMinimalerElternbeitrag())
			&& comparesEqual(getVerfuegteAnzahlZeiteinheiten(), that.getVerfuegteAnzahlZeiteinheiten())
			&& comparesEqual(
			getAnspruchsberechtigteAnzahlZeiteinheiten(),
			that.getAnspruchsberechtigteAnzahlZeiteinheiten())
			&& getZeiteinheit() == that.getZeiteinheit()
			&& comparesEqual(getMassgebendesEinkommen(), that.getMassgebendesEinkommen())
			&& isBesondereBeduerfnisse() == that.isBesondereBeduerfnisse();
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getVon(),
			getBis(),
			getEffektiveBetreuungPct(),
			getAnspruchPct(),
			getVerguenstigtPct(),
			getVollkosten(),
			getBetreuungsgutschein(),
			getBetreuungsgutscheinGemeinde(),
			getBetreuungsgutscheinKanton(),
			getMinimalerElternbeitrag(),
			getVerguenstigung(),
			getVerfuegteAnzahlZeiteinheiten(),
			getAnspruchsberechtigteAnzahlZeiteinheiten(),
			getZeiteinheit(),
			getMassgebendesEinkommen(),
			isBesondereBeduerfnisse());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", ZeitabschnittDTO.class.getSimpleName() + '[', "]")
			.add("von=" + von)
			.add("bis=" + bis)
			.add("effektiveBetreuungPct=" + effektiveBetreuungPct)
			.add("anspruchPct=" + anspruchPct)
			.add("verguenstigtPct=" + verguenstigtPct)
			.add("vollkosten=" + vollkosten)
			.add("betreuungsgutschein=" + betreuungsgutschein)
			.add("betreuungsgutscheinGemeinde=" + betreuungsgutscheinGemeinde)
			.add("betreuungsgutscheinKanton=" + betreuungsgutscheinKanton)
			.add("minimalerElternbeitrag=" + minimalerElternbeitrag)
			.add("verguenstigung=" + verguenstigung)
			.add("verfuegteAnzahlZeiteinheiten=" + verfuegteAnzahlZeiteinheiten)
			.add("anspruchsberechtigteAnzahlZeiteinheiten=" + anspruchsberechtigteAnzahlZeiteinheiten)
			.add("zeiteinheit=" + zeiteinheit)
			.add("massgebendesEinkommen=" + massgebendesEinkommen)
			.add("besondereBeduerfnisse=" + besondereBeduerfnisse)
			.toString();
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
	public BigDecimal getEffektiveBetreuungPct() {
		return effektiveBetreuungPct;
	}

	public void setEffektiveBetreuungPct(@Nonnull BigDecimal effektiveBetreuungPct) {
		this.effektiveBetreuungPct = effektiveBetreuungPct;
	}

	@Nonnull
	public Integer getAnspruchPct() {
		return anspruchPct;
	}

	public void setAnspruchPct(@Nonnull Integer anspruchPct) {
		this.anspruchPct = anspruchPct;
	}

	@Nonnull
	public BigDecimal getVerguenstigtPct() {
		return verguenstigtPct;
	}

	public void setVerguenstigtPct(@Nonnull BigDecimal verguenstigtPct) {
		this.verguenstigtPct = verguenstigtPct;
	}

	@Nonnull
	public BigDecimal getVollkosten() {
		return vollkosten;
	}

	public void setVollkosten(@Nonnull BigDecimal vollkosten) {
		this.vollkosten = vollkosten;
	}

	@Nullable
	public BigDecimal getBetreuungsgutschein() {
		return betreuungsgutschein;
	}

	public void setBetreuungsgutschein(@Nullable BigDecimal betreuungsgutschein) {
		this.betreuungsgutschein = betreuungsgutschein;
	}

	@Nullable
	public BigDecimal getBetreuungsgutscheinGemeinde() {
		return betreuungsgutscheinGemeinde;
	}

	public void setBetreuungsgutscheinGemeinde(@Nullable BigDecimal betreuungsgutscheinGemeinde) {
		this.betreuungsgutscheinGemeinde = betreuungsgutscheinGemeinde;
	}

	@Nullable
	public BigDecimal getBetreuungsgutscheinKanton() {
		return betreuungsgutscheinKanton;
	}

	public void setBetreuungsgutscheinKanton(@Nullable BigDecimal betreuungsgutscheinKanton) {
		this.betreuungsgutscheinKanton = betreuungsgutscheinKanton;
	}

	@Nullable
	public BigDecimal getMinimalerElternbeitrag() {
		return minimalerElternbeitrag;
	}

	public void setMinimalerElternbeitrag(@Nullable BigDecimal minimalerElternbeitrag) {
		this.minimalerElternbeitrag = minimalerElternbeitrag;
	}

	@Nonnull
	public BigDecimal getVerguenstigung() {
		return verguenstigung;
	}

	public void setVerguenstigung(@Nonnull BigDecimal verguenstigung) {
		this.verguenstigung = verguenstigung;
	}

	@Nullable
	public BigDecimal getVerfuegteAnzahlZeiteinheiten() {
		return verfuegteAnzahlZeiteinheiten;
	}

	public void setVerfuegteAnzahlZeiteinheiten(@Nullable BigDecimal verfuegteAnzahlZeiteinheiten) {
		this.verfuegteAnzahlZeiteinheiten = verfuegteAnzahlZeiteinheiten;
	}

	@Nullable
	public BigDecimal getAnspruchsberechtigteAnzahlZeiteinheiten() {
		return anspruchsberechtigteAnzahlZeiteinheiten;
	}

	public void setAnspruchsberechtigteAnzahlZeiteinheiten(
		@Nullable BigDecimal anspruchsberechtigteAnzahlZeiteinheiten) {
		this.anspruchsberechtigteAnzahlZeiteinheiten = anspruchsberechtigteAnzahlZeiteinheiten;
	}

	@Nullable
	public Zeiteinheit getZeiteinheit() {
		return zeiteinheit;
	}

	public void setZeiteinheit(@Nullable Zeiteinheit zeiteinheit) {
		this.zeiteinheit = zeiteinheit;
	}

	@Nonnull
	public BigDecimal getMassgebendesEinkommen() {
		return massgebendesEinkommen;
	}

	public void setMassgebendesEinkommen(@Nonnull BigDecimal massgebendesEinkommen) {
		this.massgebendesEinkommen = massgebendesEinkommen;
	}

	public boolean isBesondereBeduerfnisse() {
		return besondereBeduerfnisse;
	}

	public void setBesondereBeduerfnisse(boolean besondereBeduerfnisse) {
		this.besondereBeduerfnisse = besondereBeduerfnisse;
	}
}
