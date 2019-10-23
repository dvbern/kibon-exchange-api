/*
 * Copyright (C) 2019 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.verfuegung.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Zeitabschnitt {

	@Nonnull
	LocalDate getVon();

	@Nonnull
	LocalDate getBis();

	/**
	 * Laufnummber der Verfügung, die dieser Zeitabschnitt referenziert.
	 * <p>
	 * Es können Zeitabschnitte aus einer verherigen Verfügung in dem KiTax Export enthalten sein (wenn es ignorierte
	 * Zeitabschnitte gibt).
	 *
	 * @since kiBon (schema 2.0), kiTax (schema 1.1)
	 */
	@Nullable
	Integer getVerfuegungNr();

	/**
	 * Bezeichnet das mit der Betreuungsinstitution vereinbarte Betreuungspensum in %.
	 */
	@Nonnull
	BigDecimal getEffektiveBetreuungPct();

	/**
	 * Bezeichnet das anspruchsberechtigte Betreuungspensum in %, d.h. das Betreuungspensum, das durch die Gemeinde
	 * maximal durch einen Betreuungsgutschein vergünstigt würde.
	 */
	@Nonnull
	Integer getAnspruchPct();

	/**
	 * Bezeichnet das anspruchsberechtigte Betreuungspensum in %, d.h. das Betreuungspensum, das durch die Gemeinde
	 * maximal durch einen Betreuungsgutschein vergünstigt würde.
	 */
	@Nonnull
	BigDecimal getVerguenstigtPct();

	/**
	 * Bezeichnet die Betreuungskosten in CHF der Institution für das vergünstigte Pensum. Kosten für Mahlzeiten und
	 * allfällige Zusatzleistungen wie Windeln etc. sind in diesem Betrag nicht enthalten.
	 * <p>
	 * Neu werden Betreuungskosten von den Institutionen und nicht mehr vom Kanton festgelegt (bei der
	 * Platzbestätigung)
	 */
	@Nonnull
	BigDecimal getVollkosten();

	/**
	 * Der berechnete Gutschein in CHF bezeichnet die Vergünstigung, welche aufgrund des vergünstigten Pensums und
	 * des
	 * für die Berechnung des Gutscheins massgebenden Einkommens resultiert.
	 * <p>
	 * Falls der berechnete Gutschein höher ist als die Betreuungskosten, wird der berechnete Gutschein gekürzt, so
	 * dass der Gutschein die betreuungskosten nicht übersteigt.
	 *
	 * @since kiBon (schema 2.0)
	 */
	@Nullable
	BigDecimal getBetreuungsgutschein();

	/**
	 * Die Eltern müssen einen minimalen Elternbeitrag leisten. Falls dies noch nicht der Fall ist, weil die Kosten
	 * vollständig oder fast vollständig durch den Betreuungsgutschein gedeckt werden, muss die Kita oder
	 * Tagesfamilienorganisation den Eltern den (fehlenden) minimalen Elternbeitrag in Rechnung stellen. Der
	 * minimale
	 * Elternbeitrag beträgt 7 Franken pro Betreuungstag (20% Pensum pro Woche) in einer Kita und 70 Rappen pro
	 * Betreuungsstunde bei Tagesfamilien.
	 *
	 * @since kiBon (schema 2.0)
	 */
	@Nullable
	BigDecimal getMinimalerElternbeitrag();

	/**
	 * Bezeichnet den Betrag in CHF, der an die Kita überwiesen wird. Dieser entspricht dem Betreuungsgutschein
	 * abzüglich eines allfälligen minimalen Elternbeitrags (den die Kita bzw. die Tagesfamilienorganisation den
	 * Eltern in Rechnung stellen würde).
	 */
	@Nonnull
	BigDecimal getVerguenstigung();
}
