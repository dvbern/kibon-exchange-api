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

package ch.dvbern.kibon.exchange.api.common.verfuegung;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ch.dvbern.kibon.exchange.api.common.betreuung.BetreuungsAngebot;
import ch.dvbern.kibon.exchange.api.common.shared.Zeiteinheit;

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
	 * <p>
	 * {@code getVerguenstigtPct()} = MIN({@link #getEffektiveBetreuungPct()}, {@link #getAnspruchPct()})
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
	 * des für die Berechnung des Gutscheins massgebenden Einkommens resultiert.
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
	 * Bezeichnet den Betrag in CHF, der an die Institution überwiesen wird. Dieser entspricht dem Betreuungsgutschein
	 * abzüglich eines allfälligen minimalen Elternbeitrags (den die Kita bzw. die Tagesfamilienorganisation den
	 * Eltern in Rechnung stellen würde).
	 */
	@Nonnull
	BigDecimal getVerguenstigung();

	/**
	 * Die Anzahl der Zeiteinheiten, die innerhalb der Periode dieses Zeitabschnitts belegt werden dürfen.
	 * <br>
	 * Nonnull in schema 2.1
	 *
	 * @since kiBon (schema 2.1)
	 */
	@Nullable
	BigDecimal getVerfuegteAnzahlZeiteinheiten();

	/**
	 * Die Anzahl der Zeitenheiten, innerhalb der Periode dieses Zeitabschnitts für welche ein Anspruch besteht.
	 * <br>
	 * Nonnull in schema 2.1
	 *
	 * @since kiBon (schema 2.1)
	 */
	@Nullable
	BigDecimal getAnspruchsberechtigteAnzahlZeiteinheiten();

	/**
	 * Je nach {@link BetreuungsAngebot} gelten unterschiedliche Zeitenheiten. Grundsätzlich wird die Anzahl
	 * Betreuungs-Tage nach ASIV innerhalb der Periode verfügt. Bei TAGESFAMILIEN wird jedoch ein Gutschein für eine
	 * bestimmte Anzahl Betreuungsstunden verfügt.
	 * <br>
	 * Nonnull in schema 2.1
	 *
	 * @since kiBon (schema 2.1)
	 */
	@Nullable
	Zeiteinheit getZeiteinheit();

	/**
	 * ki-Tax rules apply when Regelwerk is "FEBR", otherwise the normal kiBon rules were used
	 * <br>
	 * Nonnull in schema 2.2
	 *
	 * @since kiBon (schema 2.2)
	 */
	@Nonnull
	Regelwerk getRegelwerk();

	/**
	 * Zeigt an, ob der Gutschein für den Zeitabschnitt direkt an die Eltern überwiesen wird.
	 *
	 *  @since kiBon (schema 2.3)
	 */
	boolean isAuszahlungAnEltern();

	/**
	 * Bezeichnet den Betrag in CHF, der an die Eltern überwiesen wird. Dieser entspricht dem Betreuungsgutschein
	 * abzüglich eines allfälligen minimalen Elternbeitrags (den die Kita bzw. die Tagesfamilienorganisation
	 * den Eltern in Rechnung stellen würde).
	 *
	 * @since kiBon (schema 2.3)
 	 */
	@Nullable
	BigDecimal getAnElternUeberwiesenerBetrag();
}
