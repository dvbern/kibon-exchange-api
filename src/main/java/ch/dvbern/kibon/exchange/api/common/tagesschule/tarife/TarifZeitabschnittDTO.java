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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class TarifZeitabschnittDTO implements Serializable {

	private static final long serialVersionUID = 373903231409037318L;

	@Schema(description = "Dieser Tarif gilt ab dem diesem Datum")
	@NotNull
	@Nonnull
	private LocalDate von;

	@Schema(description = "Dieser Tarif gilt bis zu dem diesem Datum")
	@NotNull
	@Nonnull
	private LocalDate bis;

	@Schema(description = "Massgebendes Einkommen für die Berechnung der Tarife (nach Abzug der Familiengrösse)")
	@Nullable
	private BigDecimal massgebendesEinkommen;

	@Schema(description = "Berücksichtigte Familiengrösse")
	@Nullable
	private BigDecimal familienGroesse;

	@Valid
	@Nullable
	private TarifDTO tarifPaedagogisch;

	@Valid
	@Nullable
	private TarifDTO tarifNichtPaedagogisch;

	public TarifZeitabschnittDTO() {
		von = LocalDate.MIN;
		bis = LocalDate.MAX;
		massgebendesEinkommen = null;
		familienGroesse = null;
		tarifPaedagogisch = null;
		tarifNichtPaedagogisch = null;
	}

	public TarifZeitabschnittDTO(
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nullable BigDecimal massgebendesEinkommen,
		@Nullable TarifDTO tarifPaedagogisch,
		@Nullable TarifDTO tarifNichtPaedagogisch) {
		this.von = von;
		this.bis = bis;
		this.massgebendesEinkommen = massgebendesEinkommen;
		this.tarifPaedagogisch = tarifPaedagogisch;
		this.tarifNichtPaedagogisch = tarifNichtPaedagogisch;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", TarifZeitabschnittDTO.class.getSimpleName() + '[', "]")
			.add("von=" + von)
			.add("bis=" + bis)
			.add("massgebendesEinkommen=" + massgebendesEinkommen)
			.add("familienGroesse=" + familienGroesse)
			.add("tarifPaedagogisch=" + tarifPaedagogisch)
			.add("tarifNichtPaedagogisch=" + tarifNichtPaedagogisch)
			.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TarifZeitabschnittDTO)) {
			return false;
		}

		TarifZeitabschnittDTO that = (TarifZeitabschnittDTO) o;

		return getVon().equals(that.getVon())
			&& getBis().equals(that.getBis())
			&& (getMassgebendesEinkommen() == null ?
			that.getMassgebendesEinkommen() == null :
			getMassgebendesEinkommen().compareTo(that.getMassgebendesEinkommen()) == 0)
			&& (getFamilienGroesse() == null ?
			that.getFamilienGroesse() == null :
			getFamilienGroesse().compareTo(that.getFamilienGroesse()) == 0)
			&& Objects.equals(getTarifPaedagogisch(), that.getTarifPaedagogisch())
			&& Objects.equals(getTarifNichtPaedagogisch(), that.getTarifNichtPaedagogisch());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getVon(),
			getBis(),
			getMassgebendesEinkommen(),
			getFamilienGroesse(),
			getTarifPaedagogisch(),
			getTarifNichtPaedagogisch());
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

	@Nullable
	public BigDecimal getMassgebendesEinkommen() {
		return massgebendesEinkommen;
	}

	public void setMassgebendesEinkommen(@Nullable BigDecimal massgebendesEinkommen) {
		this.massgebendesEinkommen = massgebendesEinkommen;
	}

	@Nullable
	public BigDecimal getFamilienGroesse() {
		return familienGroesse;
	}

	public void setFamilienGroesse(@Nullable BigDecimal familienGroesse) {
		this.familienGroesse = familienGroesse;
	}

	@Nullable
	public TarifDTO getTarifPaedagogisch() {
		return tarifPaedagogisch;
	}

	public void setTarifPaedagogisch(@Nullable TarifDTO tarifPaedagogisch) {
		this.tarifPaedagogisch = tarifPaedagogisch;
	}

	@Nullable
	public TarifDTO getTarifNichtPaedagogisch() {
		return tarifNichtPaedagogisch;
	}

	public void setTarifNichtPaedagogisch(@Nullable TarifDTO tarifNichtPaedagogisch) {
		this.tarifNichtPaedagogisch = tarifNichtPaedagogisch;
	}
}
