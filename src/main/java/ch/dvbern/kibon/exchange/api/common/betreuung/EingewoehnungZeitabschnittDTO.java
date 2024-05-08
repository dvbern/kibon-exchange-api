/*
 * Copyright (C) 2024 DV Bern AG, Switzerland
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class EingewoehnungZeitabschnittDTO implements Serializable {

	private static final long serialVersionUID = 5237990963578524998L;

	@Schema(description = "Verrechnete Eingewöhnungskosten in CHF")
	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal kosten = BigDecimal.ZERO;

	@Schema(description = "Beginn der Eingewöhnungsphase")
	@Nonnull
	private @NotNull LocalDate von = LocalDate.MIN;

	@Schema(description = "Ende der Eingewöhnungsphase")
	@Nonnull
	private @NotNull LocalDate bis = LocalDate.MIN;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof EingewoehnungZeitabschnittDTO)) {
			return false;
		}
		EingewoehnungZeitabschnittDTO that = (EingewoehnungZeitabschnittDTO) o;
		return getKosten().compareTo(that.getKosten()) == 0 &&
			Objects.equals(getVon(), that.getVon()) &&
			Objects.equals(getBis(), that.getBis());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getKosten(), getVon(), getBis());
	}

	@Nonnull
	public BigDecimal getKosten() {
		return kosten;
	}

	public void setKosten(@Nonnull BigDecimal kosten) {
		this.kosten = kosten;
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
}
